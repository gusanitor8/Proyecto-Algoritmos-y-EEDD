import ArithmeticProcessing.Parser;
import ArithmeticProcessing.Postfix;

public class Interpreter {
    Vista vista = new Vista();
    Parser parser = new Parser();
    Postfix postfix = new Postfix();

    public void run(){
        boolean condition = true;
        int lineCount = 1;



        while (condition){
            String expression = vista.display(lineCount);
            expression = vista.rmParentheses(expression);
            String end = postfix.evaluate(parser.stringToQueue(expression));
            System.out.println(end);


            lineCount += 1;
        }
    }

}
