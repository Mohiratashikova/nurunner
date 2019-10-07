public abstract class AssessmentFactory {
    public Common common;
    public AssessmentFactory (Common c) {
        this.common = c;
    }
    public abstract Assessment createAssessment (Vector2D position);
}