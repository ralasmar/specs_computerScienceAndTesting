package main.test.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

//parameterized tests make it easier to write tests with many conditions
@RunWith(Parameterized.class)
public class ParameterizedTest {
    private String input;
    private boolean expectedOutput;
    main.java.BalancedBrackets bb = new main.java.BalancedBrackets();

    public ParameterizedTest(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        String balancedParentheses = "(6)";
        String MoreOpenParentheses = "((6)";
        String MoreClosedParentheses = "(6))";
        String balancedSquareBrackets = "[[6]]";
        String MoreOpenSquare = "[[6]";
        String balancedMixed = "([6])";
        String MoreClosedMixed = "([6]])";

        Object[][] expectedOutputs = {
                {balancedParentheses, true},
                {MoreOpenParentheses, false},
                {MoreClosedParentheses, false},
                {balancedSquareBrackets, true},
                {MoreOpenSquare, false},
                {balancedMixed, true},
                {MoreClosedMixed, false}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testBalancedBrackets() {
        assertEquals(expectedOutput, bb.balancedBrackets(input));
    }
}
