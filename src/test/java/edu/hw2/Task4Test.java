package edu.hw2;

import edu.hw2.Task1.Addition;
import edu.hw2.Task1.Constant;
import edu.hw2.Task1.Exponent;
import edu.hw2.Task1.Multiplication;
import edu.hw2.Task1.Negate;
import edu.hw2.Task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("defaultTest")
    public void test1() {
        var tst = Task4.callingInfo();

        var ans =  "CallingInfo[className=com.intellij.rt.junit.JUnitStarter, methodName=main]";

        assertThat(ans).isEqualTo(tst.toString());
    }
}
