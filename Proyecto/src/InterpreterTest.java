import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    public void findAndReplaceVarTest(){
        Interpreter inter = new Interpreter();
        Variable var = new Variable(new String[]{"x", "10", "boolean"});
        String expression = "+ x 2";
        String expression2 = "x";
        String expression3 = "+ 2 x";

        assertEquals("+ 10 2", inter.findAndReplaceVar(expression));
        assertEquals("10", inter.findAndReplaceVar(expression2));
        assertEquals("+ 2 10", inter.findAndReplaceVar(expression3));
    }
}