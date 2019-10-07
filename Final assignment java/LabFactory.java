public class LabFactory extends AssessmentFactory {
    public LabFactory(Common c) {
        super(c);
    }
    @Override
    public Assessment createAssessment(Vector2D position) {
        return new Lab(common, position);
    }
}