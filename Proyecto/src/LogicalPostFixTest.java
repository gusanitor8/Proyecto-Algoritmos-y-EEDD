import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicalPostFixTest {
    @Test
    public void operateTest() {
        LogicalPostFix logic = new LogicalPostFix();

        String expression = "= 1 1";
        String expression2 = "< 1 2";
        String expression3 = "> 3 2";
        String expression4 = "> 2 2";

        assertEquals("t",logic.operate(expression));
        assertEquals("t",logic.operate(expression2));
        assertEquals("t",logic.operate(expression3));
        assertEquals("nil",logic.operate(expression4));
    }
}