package jp.co.acroquest.optional;

import java.util.Optional;
import java.util.Set;

public class Student {

    private String name;

    private Set<Score> scores;

    public Student(String name, Set<Score> scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public Optional<Score> getScore(Subject subject) {
        for (Score score : scores) {
            if(score.getSubject() == subject) {
                return Optional.of(score);
            }
        }
        return Optional.empty();
    }
}
