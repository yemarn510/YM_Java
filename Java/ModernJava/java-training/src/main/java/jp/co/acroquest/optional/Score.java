package jp.co.acroquest.optional;

public class Score {

    private Subject subject;
    private int value;

    public Score(Subject subject, int value) {
        this.subject = subject;
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getValue() {
        return value;
    }
}
