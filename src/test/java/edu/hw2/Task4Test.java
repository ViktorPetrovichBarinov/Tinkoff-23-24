package edu.hw2;

import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("defaultTest")
    public void test1() {
        var tst = Task4.callingInfo();

        var ans =  "CallingInfo[className=edu.hw2.Task4Test, methodName=test1]";

        assert tst != null;
        assertThat(ans).isEqualTo(tst.toString());
    }
}
