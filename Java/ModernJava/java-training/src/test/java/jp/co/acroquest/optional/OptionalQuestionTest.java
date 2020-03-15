package jp.co.acroquest.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OptionalQuestionTest
{

    private OptionalQuestion target = new OptionalQuestion();

    @Test
    void emptyOptional()
    {
        Optional<Void> result = target.emptyOptional();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void optionalWithString()
    {
        Optional<String> java = target.optionalWithString("Java");
        assertNotNull(java);
        assertEquals("Java", java.get());

        assertThrows(NullPointerException.class,
                () -> target.optionalWithString(null));
    }

    @Test
    void createOptionalByNullable()
    {
        Optional<String> java = target.createOptionalByNullable("Java");
        assertNotNull(java);
        assertEquals("Java", java.get());

        Optional<String> empty = target.createOptionalByNullable(null);
        assertNotNull(empty);
        assertTrue(empty.isEmpty());
    }

    @Test
    void checkIfPresent()
    {
        assertTrue(target.checkIfPresent(Optional.of("Java")));
        assertFalse(target.checkIfPresent(Optional.empty()));
    }

    @Test
    void checkIfEmpty()
    {
        assertFalse(target.checkIfEmpty(Optional.of("Java")));
        assertTrue(target.checkIfEmpty(Optional.empty()));
    }

    @Test
    void orElseGet()
    {
        String java = target.orElseGet(Optional.of("Java"));
        assertNotNull(java);
        assertEquals("Java", java);
        String hello = target.orElseGet(Optional.empty());
        assertNotNull(hello);
        assertEquals("Hello!", hello);
    }

    @Test
    void orElseThrow()
    {
        String java = target.orElseThrow(Optional.of("Java"));
        assertNotNull(java);
        assertEquals("Java", java);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> target.orElseThrow(Optional.empty()));
        assertEquals("Argument must not be empty", exception.getMessage());
    }

    @Test
    void filterIfStringStartsWithA()
    {
        Optional<String> java = target.filterIfStringStartsWithA(
                Optional.of("Java"));
        assertNotNull(java);
        assertTrue(java.isEmpty());

        Optional<String> arithmetic = target.filterIfStringStartsWithA(
                Optional.of("Arithmetic"));
        assertNotNull(arithmetic);
        assertEquals("Arithmetic", arithmetic.get());

        Optional<String> empty = target.filterIfStringStartsWithA(
                Optional.empty());
        assertNotNull(empty);
        assertTrue(empty.isEmpty());
    }

    @Test
    void mapToUpperCase()
    {
        Optional<String> java = target.mapToUpperCase(Optional.of("java"));
        assertNotNull(java);
        assertEquals("JAVA", java.get());

        Optional<String> empty = target.mapToUpperCase(Optional.empty());
        assertNotNull(empty);
        assertTrue(empty.isEmpty());
    }

    @Test
    void getScoreOfMathematics()
    {
        Student student = new Student("Miyajima",
                Set.of(new Score(Subject.SCIENCE, 60),
                        new Score(Subject.HISTORY, 70),
                        new Score(Subject.MATHEMATICS, 80)));
        Optional<Score> score = target.getScoreOfMathematics(
                Optional.of(student));
        assertNotNull(score);
        assertEquals(Subject.MATHEMATICS, score.get().getSubject());
        assertEquals(80, score.get().getValue());
    }

    @Test
    void getNameLowerCaseIfStartsWithS()
    {
        Student smith = new Student("Smith", Set.of());
        String maybeSmith = target.getNameLowerCaseIfStartsWithS(
                Optional.of(smith));
        assertNotNull(maybeSmith);
        assertEquals("smith", maybeSmith);

        Student john = new Student("Johnson", Set.of());
        String maybeJohn = target.getNameLowerCaseIfStartsWithS(
                Optional.of(john));
        assertNotNull(maybeJohn);
        assertEquals("Unknown", maybeJohn);
    }

    @Test
    void getScoreValueWithCondition()
    {
        Student student1 = new Student("Smith",
                Set.of(new Score(Subject.HISTORY, 60),
                        new Score(Subject.MATHEMATICS, 70),
                        new Score(Subject.SCIENCE, 90)));
        assertThrows(RuntimeException.class,
                () -> target.getScoreValueWithCondition(Optional.of(student1)));

        Student student2 = new Student("Smith",
                Set.of(new Score(Subject.HISTORY, 81),
                        new Score(Subject.MATHEMATICS, 70),
                        new Score(Subject.SCIENCE, 90)));
        int value = target.getScoreValueWithCondition(Optional.of(student2));
        assertEquals(90, value);

        assertThrows(RuntimeException.class,
                () -> target.getScoreValueWithCondition(Optional.empty()));
    }
}
