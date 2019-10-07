import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.util.Arrays;

public class Common {
    public int windowWidth;
    public int windowHeight;
    public UniversityMap map;
    public List<Academician> academicians;
    public List<Speaker> speakers;
    public List<Student> students;
    public List<Assessment> assessments;

    public Random rand = new Random();
    public Vector2D amphitheater = new Vector2D(830, 480);

    public Common (int width, int height) {
        this.windowWidth = width;
        this.windowHeight = height;

        map = new UniversityMap(width, height, this);

        academicians = new ArrayList<Academician>();
        academicians.add(new Academician("Nivelle", this));
        academicians.add(new Academician("Temizer", this));
        academicians.add(new Academician("Katsu", this));
        academicians.add(new Academician("Tourassis", this));

        speakers = new ArrayList<Speaker>();
        speakers.add(new Speaker("Nazarbayev", this));
        speakers.add(new Speaker("Tokayev", this));

        students = new ArrayList<Student>();
        students.add(new Student("Emir", this));
        students.add(new Student("Aigerim", this));
        students.add(new Student("Sanzhar", this));
        students.add(new Student("Shynggys", this));
        students.add(new Student("Aysana", this));
        students.add(new Student("Nartay", this));
        students.add(new Student("Allan", this));
        students.add(new Student("Amir", this));
        students.add(new Student("Khadisha", this));
        students.add(new Student("Abilkhaiyr", this));
        assessments = new ArrayList<Assessment>();
    }
    
    public int randomInt (int from, int to) {
        return rand.nextInt((to - from) + 1) + from;
    }

    public void stepAllEntities() {
        for (Academician a : academicians)  {
            if (a.state.isOver) {
                int acad = randomInt(0, 2);
                if (acad == 0) {
                    a.state = new Rest(randomInt(1, 100), this);
                } else if (acad == 1) {
                    Vector2D direction= new Vector2D(randomInt(0, windowWidth-a.width), randomInt(0, windowHeight-a.height));
                    a.state = new ZigZag(direction, randomInt(1, 100), this);
                } else {
                    Vector2D direction= new Vector2D(randomInt(0, windowWidth-a.width), randomInt(0, windowHeight-a.height));
                    a.state = new GotoXY(direction, this);
                }
            }
            if (!a.state.name.equals("Rest")) {
                int randomnum = randomInt(0, 10);
                if (randomnum == 6) {
                    assessments.add(a.createAssessment());
                }
            }
            a.state.step(a);
        }

        for (Student s : students)  {
            if (s.grade >= 100) {
                if (s.position.distanceTo(amphitheater) < 10) {
                    s.state = new Stationary(this); 
                } else {
                    s.state = new GotoXY (new Vector2D(amphitheater.x+randomInt(0, 10), amphitheater.y + randomInt(0, 10)), this);
                }
            } else {
                if (s.state.isOver) {
                    int stud = randomInt(0, 3);
                    if (stud == 0) {
                        s.state = new Rest(randomInt(1, 100), this);
                    } else if (stud == 1) {
                        Vector2D direction= new Vector2D(randomInt(0, windowWidth-s.width), randomInt(0, windowHeight-s.height));
                        s.state = new ZigZag(direction, randomInt(1, 100), this);
                    } else if (stud == 2) {
                        Vector2D direction= new Vector2D(randomInt(0, windowWidth-s.width), randomInt(0, windowHeight-s.height));
                        s.state = new GotoXY(direction, this);
                    } else {
                        s.state = new Closest(this);
                    }
                }
                for (Assessment as : assessments)  {
                    if (as.state.isVisible) {
                        if (s.position.distanceTo(as.position) <= 5) {
                            s.grade += as.points;
                            as.state.isVisible = false;
                        }
                    }
                }
            }
            s.state.step(s);
        }
    }

    public void drawAllEntities (Graphics2D g2d) {
        int i = 0;
        map.draw(g2d);
        for (Student s : students)  {
            if (s.grade < 100) {
                break;
            } else {
                i++;
            }            
        }
        if (i < 10) {
            for (Assessment as : assessments)  {
                if (as.state.isVisible) {
                    as.draw(g2d);
                }  
            }
            for (Student s : students)  {
                s.draw(g2d);
            }
            for (Academician a : academicians)  {
                a.draw(g2d);
            }
        } else {
            double offset = 0;
            for (Academician a : academicians)  {
                a.position.x = 720+offset;
                a.position.y = 370;
                a.state = new Stationary(this);
                a.draw(g2d);
                offset += 70;
            }
            double offs = 0;
            for (Speaker s : speakers){
                s.position.x = 730 + offs;
                s.position.y = 470;
                s.draw(g2d);
                offs += 200;
            }
            for (Student s : students)  {
                s.draw(g2d);
            }
            g2d.drawString("Graduation Ceremony", 800, 560);
        }
    }
}