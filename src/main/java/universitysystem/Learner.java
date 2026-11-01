package universitysystem;

public class Learner extends CampusPerson {
    private double score;

    public Learner(int id, String name, String email, double score) {
        super(id, name, email);
        this.score = score;
    }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public double calculateGPA() {
        return score / 25.0;
    }

    @Override
    public String toString() {
        return "Learner " + super.toString() + String.format(" | GPA %.2f", calculateGPA());
    }
}