package jp.co.acroquest.lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LabmdaQuestionTest {

    private LabmdaQuestion target = new LabmdaQuestion();

    private PrintStream originalOut = System.out;
    private PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        originalOut = System.out;
        originalErr = System.err;
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void mapToUpperCase() {
        Function<String, String> function = target.mapToUpperCase();
        assertNotNull(function);
        assertEquals("JAVA", function.apply("java"));
        assertEquals("JAVA", function.apply("Java"));
        assertEquals("JAVA", function.apply("JAVA"));
    }

    @Test
    void convertToFullName() {
        Function<String, FullName> function = target.convertToFullName();
        assertNotNull(function);
        assertEquals(createFullName("John", "Lennon"), function.apply("John Lennon"));
        assertEquals(createFullName("Paul", "McCartney"), function.apply("Paul McCartney"));
    }

    private FullName createFullName(String firstName, String lastName) {
        FullName fullName = new FullName();
        fullName.setFirstName(firstName);
        fullName.setLastName(lastName);
        return fullName;
    }

    @Test
    void max() {
        BiFunction<Integer, Integer, Integer> function = target.max();
        assertNotNull(function);
        assertEquals(2, function.apply(1, 2));
        assertEquals(2, function.apply(2, 1));
        assertEquals(5, function.apply(-1, 5));
        assertEquals(5, function.apply(5, -5));
    }

    @Test
    void runtimeExceptionSupplier() {
        Supplier<RuntimeException> supplier = target.runtimeExceptionSupplier();
        assertNotNull(supplier);
        assertTrue(supplier.get() instanceof RuntimeException);
    }

    @Test
    void printConsumer() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        Consumer<String> consumer = target.printConsumer();
        assertNotNull(consumer);
        String hello = "Hello, World!";
        consumer.accept(hello);
        assertEquals(hello + System.lineSeparator(), new String(outContent.toByteArray()));
    }

    @Test
    void checkOver30() {
        Predicate<Integer> predicate = target.checkOver30();
        assertNotNull(predicate);

        assertTrue(predicate.test(40));
        assertTrue(predicate.test(31));
        assertFalse(predicate.test(30));
        assertFalse(predicate.test(20));
    }
}
