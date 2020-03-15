package jp.co.acroquest.optional;

import java.util.Optional;

/**
 * Answer following questions.
 *
 * @see <a href="https://www.baeldung.com/java-optional">Baeldung.com - Guide To Java 8 Optional</a>
 */
public class OptionalQuestion
{

    /**
     * Question 1:
     * <pre>
     *     Create empty Optional object.
     * </pre>
     *
     * @return
     */
    public Optional<Void> emptyOptional()
    {
        return Optional.empty();
    }

    /**
     * Question 2:
     * <pre>
     *     Create Optional object with the argument. (the argument is not null).
     * </pre>
     *
     * @param s
     * @return
     */
    public Optional<String> optionalWithString(String s)
    {
        return Optional.of(s);
    }

    /**
     * Question 3:
     * <pre>
     *     Create Optional object by an argument.
     *     Caution: the argument may be null. This method must not throw any exceptions.
     * </pre>
     *
     * @param s
     * @return
     */
    public Optional<String> createOptionalByNullable(String s)
    {
        return Optional.ofNullable(s);
    }

    /**
     * Question 4:
     * <pre>
     *     Check given optional is present.
     * </pre>
     *
     * @param maybeString
     * @return
     */
    public boolean checkIfPresent(Optional<String> maybeString)
    {
        return (maybeString.isPresent());
    }

    /**
     * Question 5:
     * <pre>
     *     Check given optional is empty.
     * </pre>
     *
     * @param maybeString
     * @return maybeString
     */
    public boolean checkIfEmpty(Optional<String> maybeString)
    {
        return (maybeString.isEmpty());
    }

    /**
     * Question 6:
     * <pre>
     *     If given optional object is present, return its value.
     *     If it is empty, return default value "Hello!".
     * </pre>
     *
     * @param maybeString
     * @return
     */
    public String orElseGet(Optional<String> maybeString)
    {
        if (maybeString.isPresent())
        {
            return maybeString.get();
        }
        else
        {
            return "Hello!";
        }
    }

    /**
     * Question 7:
     * <pre>
     *     If given optional object is present, return its value.
     *     If it is empty, throw IllegalArgumentException("Argument must not be empty").
     * </pre>
     *
     * @param maybeString
     * @return
     */
    public String orElseThrow(Optional<String> maybeString)
    {
        if (maybeString.isPresent())
        {
            return maybeString.get();
        }
        else
        {
            throw new IllegalArgumentException("Argument must not be empty");
        }
    }

    /**
     * Question 8:
     * <pre>
     *     Return given optional if it contains a string that starts with "A", or else an empty optional.
     * </pre>
     *
     * @param maybeString
     * @return
     */
    public Optional<String> filterIfStringStartsWithA(
            Optional<String> maybeString)
    {
        if (maybeString.isEmpty())
        {
            return Optional.empty();
        }
        else if (maybeString.get().contains("A"))
        {
            return maybeString;
        }
        else
        {
            return Optional.empty();
        }
    }

    /**
     * Question 9:
     * <pre>
     *     Convert the string in given optional to upper case.
     * </pre>
     *
     * @param maybeString
     * @return
     */
    public Optional<String> mapToUpperCase(Optional<String> maybeString)
    {
        if (maybeString.isPresent())
        {
            return Optional.of(maybeString.get().toUpperCase());
        }
        else
        {
            return Optional.empty();
        }

    }

    /**
     * Question 10:
     * <pre>
     *     Get the score of mathematics of given student, (Wrap the score with Optional.)
     * </pre>
     *
     * @param student
     * @return
     */
    public Optional<Score> getScoreOfMathematics(Optional<Student> student)
    {
        return student.get().getScore(Subject.MATHEMATICS);
    }

    /**
     * Question 11:
     * <pre>
     *     Convert student name to lower case if it stars with "S".
     *     If not, return "Unknown" as a fixed value.
     * </pre>
     *
     * @param student
     * @return
     */
    public String getNameLowerCaseIfStartsWithS(Optional<Student> student)
    {
        if (student.get().getName().startsWith("S"))
        {
            return student.get().getName().toLowerCase();
        }
        else
        {
            return "Unknown";
        }

    }

    /**
     * Question 12:
     * <pre>
     *     Get the score value of science of the student
     *     if his/her score of history is more than 80.
     *     If not, throw RuntimeException.
     * </pre>
     *
     * @param student
     * @return
     */
    public int getScoreValueWithCondition(Optional<Student> student)
    {
        Optional<Score> score = student.get().getScore(Subject.HISTORY);
        if (score.get().getValue() > 80)
        {
            Optional<Score> score1 = student.get().getScore(Subject.SCIENCE);
            return score1.get().getValue();
        }
        else
        {
            throw new RuntimeException();
        }
    }

}
