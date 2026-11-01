package universitysystem;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private int id;
    private String title;
    private List<Learner> roster = new ArrayList<>();

    public Subject(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Learner> getRoster() { return roster; }

    public void addLearner(Learner learner) {
        roster.add(learner);
    }

    @Override
    public String toString() {
        return "Subject " + id + ": " + title;
    }
}
