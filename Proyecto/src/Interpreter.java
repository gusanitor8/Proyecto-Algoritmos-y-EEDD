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

            if(vista.hasParentheses(expression)){                       //Verifica si tiene parentesis
                expression = vista.rmParentheses(expression);           //Se remueven los parentesis de la expresion

                if(vista.isArthmetic(expression)){
                    String end = postfix.evaluate(parser.stringToQueue(expression));
                    System.out.println(end);

                }else if(vista.isSetQ(expression)){
                    //TODO en caso de ser SETQ
                    System.out.println("Quiere declarar una variable");
                }

            }else{
                if(vista.isQuote(expression)){
                    //TODO si es un quote
                }
            }

            lineCount += 1;
        }
    }

}
