package universitysystem;

public class UndergradLearner extends Learner {

    public UndergradLearner(int id, String name, String email, double score) {
        super(id, name, email, score);
    }

    @Override
    public double calculateGPA() {
        return getScore() / 25.0;
    }
}