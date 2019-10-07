public class QuizFactory extends AssessmentFactory {
    public QuizFactory(Common c) {
        super(c);
    }
    @Override
    public Assessment createAssessment(Vector2D position) {
        return new Quiz(this.common, position);
    }
}