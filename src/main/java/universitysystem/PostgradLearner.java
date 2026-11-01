package universitysystem;

public class PostgradLearner extends Learner {

    public PostgradLearner(int id, String name, String email, double score) {
        super(id, name, email, score);
    }

    @Override
    public double calculateGPA() {
        return getScore() / 30.0;
    }
}
