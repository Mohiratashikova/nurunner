public class HomeworkFactory extends AssessmentFactory {
    public HomeworkFactory(Common c) {
        super(c);
    }
    @Override
    public Assessment createAssessment (Vector2D position) {
        return new Homework(common, position);
    }
}