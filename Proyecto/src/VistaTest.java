import org.junit.jupiter.api.Test;
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

        assertEquals(true, vista.checkString(expression));
        assertEquals(false, vista.checkString(expression2));
        assertEquals(false, vista.checkString(expression3));
        assertEquals(false, vista.checkString(expression4));
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
}

