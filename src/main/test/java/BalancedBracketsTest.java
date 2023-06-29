package main.test.java;
import static org.junit.Assert.*;
import org.junit.Test;
import main.java.BalancedParentheses;
import main.java.BalancedBrackets;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;


public class BalancedBracketsTest {
    String balancedParentheses = "(6)";
    String MoreOpenParentheses = "((6)";
    String MoreClosedParentheses = "(6))";
    String balancedSquareBrackets = "[[6]]";
    String MoreOpenSquare = "[[6]";
    String balancedMixed = "([6])";
    String MoreClosedMixed = "([6]])";

    private BalancedParentheses balanced = new BalancedParentheses();
    private BalancedBrackets balancedBrackets = new BalancedBrackets();

    @Test
    public void testBalancedBrackets_balancedParentheses(){
        //assertTrue checks if the output value is true
        assertTrue(balanced.balancedParentheses(balancedParentheses));
    }
    @Test
    public void testBalancedBrackets_MoreOpenParentheses(){
        //assertFalse checks if the output value is false
        assertFalse(balancedBrackets.balancedBrackets("([6)"));
    }
    @Test
    public void testBalancedBrackets_MoreClosedParentheses(){
        assertFalse(balancedBrackets.balancedBrackets("([6)])"));
    }
    @Test
    public void testBalancedBrackets_balancedSquareBrackets() {
        assertTrue(balancedBrackets.balancedBrackets("[[6]]"));
    }
    @Test
    public void testBalancedBrackets_MoreOpenSquare() {
        assertFalse(balancedBrackets.balancedBrackets("[[[[6]]"));
    }
    @Test
    public void testBalancedBrackets_balancedMixed() {
        assertTrue(balancedBrackets.balancedBrackets("<[[(6)]]>"));
    }
    @Test
    public void testBalancedBrackets_MoreClosedMix() {
        assertFalse(balancedBrackets.balancedBrackets("[{[6}}]]"));
    }
}
