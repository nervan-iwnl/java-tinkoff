package edu.hw2;

import edu.hw2.Task0.Addition;
import edu.hw2.Task0.Constant;
import edu.hw2.Task0.Exponent;
import edu.hw2.Task0.Multiplication;
import edu.hw2.Task0.Negative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task0Test {
    @Test
    @DisplayName("Expressions test1")
    public void calculatorTest1(){
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negative(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));
        assertThat(res.evaluate()).isEqualTo(37d);
    }
    @Test
    @DisplayName("Expressions test2")
    public void calculatorTest2(){
        var two = new Constant(2);
        var four = new Constant(4);
        var mTwo = new Negative(two);
        var res1 = new Addition(two, mTwo);
        assertThat(res1.evaluate()).isEqualTo(0);
        var res2 = new Exponent(mTwo, 4);
        var res3 = new Exponent(two, 4);
        assertThat(res2.evaluate()).isEqualTo(res3.evaluate());
    }
}
