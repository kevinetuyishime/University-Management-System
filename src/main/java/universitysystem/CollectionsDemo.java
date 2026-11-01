package universitysystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {

        Learner alice = new UndergradLearner(1, "Kevine", "kevine@mail.com", 80);
        Learner brian = new PostgradLearner(2, "tuyishime", "tuyishime@mail.com", 80);

        List<Learner> allLearners = new ArrayList<>();
        allLearners.add(alice);
        allLearners.add(brian);
        for (Learner l : allLearners) {
            System.out.println(l);
        }

        Subject javaSubject = new Subject(1, "Java");
        javaSubject.addLearner(alice);
        javaSubject.addLearner(brian);
        System.out.println("Java roster size: " + javaSubject.getRoster().size());

        Set<Learner> uniqueLearners = new HashSet<>(allLearners);
        uniqueLearners.add(alice);
        System.out.println("Unique learners: " + uniqueLearners.size());

        Map<String, Lecturer> lecturers = new HashMap<>();
        lecturers.put(javaSubject.getTitle(), new Lecturer(1, "Dr. Francine", "francine@mail.com", "Mechanical"));
        System.out.println("Physics is taught by " + lecturers.get("Physics").getName());
    }
}