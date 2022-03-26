import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VistaTest {
    @Test
    public void hasParenthesesTest(){
        Vista vista = new Vista();
        String expression = "(abc)";
        String expression2 = "a(bc)";
        String expression3 = "(bc)d";
        String expression4 = "abc";
        String expression5 = "abc)";

        assertEquals(true, vista.hasParentheses(expression));
        assertEquals(false, vista.hasParentheses(expression2));
        assertEquals(false, vista.hasParentheses(expression3));
        assertEquals(false, vista.hasParentheses(expression4));
        assertEquals(false, vista.hasParentheses(expression5));
    }

    @Test
    public void checkStringTest(){
        Vista vista = new Vista();
        String expression = "\"esta es una cadena\"";
        String expression2 = "esta no es una cadena";
        String expression3 = "esta tampoco\"";
        String expression4 = "\" no es una cadena :(";
        String expression5 = "\"hola\"";

        assertEquals(true, vista.checkString(expression));
        assertEquals(false, vista.checkString(expression2));
        assertEquals(false, vista.checkString(expression3));
        assertEquals(false, vista.checkString(expression4));
        assertEquals(true, vista.checkString(expression5));
    }

    @Test
    public void isArithmeticTest(){
        Vista vista = new Vista();
        String expression = "+ 2 2";
        String expression2 = " / 2 5";
        String expression3 = "^ 1 7 ";
        String expression4 = "- 1 1";
        String expression5 = "* 2 2";


        assertEquals(true, vista.isArthmetic(expression));
        assertEquals(true, vista.isArthmetic(expression2));
        assertEquals(true, vista.isArthmetic(expression3));
        assertEquals(true, vista.isArthmetic(expression4));
        assertEquals(true, vista.isArthmetic(expression5));


    }

    @Test
    public void isSetQTest(){
        Vista vista = new Vista();
        String expression = "setq n 20";
        String expression1 = "setq  20";
        String expression2 = "setq n ";
        String expression3 = "setq n \"hola\"";
        String expression4 = "setq 7 20";
        String expression5 = "setq  n2  20";
        String expression6 = "setqn220";

        assertEquals(true, vista.isSetQ(expression));
        assertEquals(false, vista.isSetQ(expression1));
        assertEquals(false, vista.isSetQ(expression2));
        assertEquals(true, vista.isSetQ(expression3));
        assertEquals(false, vista.isSetQ(expression4));
        assertEquals(true, vista.isSetQ(expression5));
        assertEquals(false, vista.isSetQ(expression6));
    }

    @Test
    public void isQuoteTest(){
        Vista vista = new Vista();
        String expression = "'(\"hola\")";
        String expression2 = "'Juan";
        String expression3 = "'( 1 2 a s)";
        String expression4 = "'22";
        String expression5 = "(\"hola\")";

        assertEquals(true, vista.isQuote(expression));
        assertEquals(true, vista.isQuote(expression2));
        assertEquals(true, vista.isQuote(expression3));
        assertEquals(true, vista.isQuote(expression4));
        assertEquals(false, vista.isQuote(expression5));
    }



    @Test
    public void getSetQExpressionTest(){
        Vista vista = new Vista();
        String expression = " setq n 10";
        String expression2 = " setq a \"hola\"";

        String[] expected = {"n", "10"};
        String[] expected2 = {"a", "hola"};

        assertArrayEquals(expected,vista.getSetQExpression(expression));
        assertArrayEquals(expected2,vista.getSetQExpression(expression2));

    }

    @Test
    public void isSetQBoolTest(){
        Vista vista = new Vista();
        String expression = " setq n nil";
        String expression2 = " setq n t";
        String expression3 = " setq a a";
        String expression4 = " setq a 20";

        assertEquals(true,vista.isSetQbool(expression));
        assertEquals(true,vista.isSetQbool(expression2));
        assertEquals(false,vista.isSetQbool(expression3));
        assertEquals(false,vista.isSetQbool(expression4));
    }

    @Test
    public void isSetQString(){
        Vista vista = new Vista();
        String expression = " setq n \"holis\"";
        String expression2 = " setq n \"20\"";
        String expression3 = " setq a a";
        String expression4 = " setq a 20";

        assertEquals(true,vista.isSetQString(expression));
        assertEquals(true,vista.isSetQString(expression2));
        assertEquals(false,vista.isSetQString(expression3));
        assertEquals(false,vista.isSetQString(expression4));
    }

    @Test
    public void isSetQnumTest(){
        Vista vista = new Vista();
        String expression = " setq n 99";
        String expression2 = " setq n 0";
        String expression3 = " setq a a";
        String expression4 = " setq a '20";

        assertEquals(true,vista.isSetQnum(expression));
        assertEquals(true,vista.isSetQnum(expression2));
        assertEquals(false,vista.isSetQnum(expression3));
        assertEquals(false,vista.isSetQnum(expression4));
    }

    @Test
    public void isLogicOperationTest(){
        Vista vista = new Vista();
        String expression = "= 1 0";
        String expression2 = " > 2 7";
        String expression3 = " < 7 x";
        String expression4 = " setq a '20";

        assertEquals(true,vista.isLogicOperation(expression));
        assertEquals(true,vista.isLogicOperation(expression2));
        assertEquals(true,vista.isLogicOperation(expression3));
        assertEquals(false,vista.isLogicOperation(expression4));
    }

    @Test
    public void isCondTest(){
        Vista vista = new Vista();
        String expression = "cond ((> a 20)" +
                "   (format t \"~% a is greater than 20\"))" +
                "   (t (format t \"~% value of a is ~d \" a))";
        String expression2 = " > 2 7";


        assertEquals(true,vista.isCond(expression));
        assertEquals(false,vista.isCond(expression2));
    }

    @Test
    public void removeQuoteTest(){
        Vista vista = new Vista();
        String expression = "'(holi soy yo)";
        String expression2 = "'(holi 'soy yo)";

        assertEquals("(holi soy yo)", vista.removeQuote(expression));
        assertEquals("(holi 'soy yo)", vista.removeQuote(expression2));
    }

    @Test
    public void isDefunTest(){
        Vista vista = new Vista();
        String expression = "defun name (x)";
        String expression2 = "defun name (x y)";

        assertEquals(true, vista.isDefun(expression));
        assertEquals(true, vista.isDefun(expression2));
    }

    @Test
    public void getFuncPartsTest(){
        Vista vista = new Vista();
        String expression = "defun    name    (x y)";

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("defun");
        expected.add("name");
        expected.add("(x)");

        assertEquals(expected, vista.getFuncParts(expression));
    }

    @Test
    public void getFuncNameTest(){
        Vista vista = new Vista();
        String expression = "defun    name    (x)";
        String expression2 = "defun    myFunc    (x y)";

        assertEquals("name", vista.getFuncName(expression));
        assertEquals("myFunc", vista.getFuncName(expression2));
    }

    @Test
    public void getFuncVarsTest(){
        Vista vista = new Vista();
        String expression = "defun    name    (x)";
        String expression2 = "defun    myFunc    (x y)";

        assertEquals("(x)", vista.getFuncVars(expression));
        assertEquals("(x y)", vista.getFuncVars(expression2));
    }
}

