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
                    expression = findAndReplaceVar(expression);
                    String end = postfix.evaluate(parser.stringToQueue(expression));
                    System.out.println(end);

                }else if(vista.isSetQ(expression)){
                    String[] valores;
                    String[] temp;

                    if(vista.isSetQString(expression)){
                        //TODO que hacer si la variable es una cadena
                        //System.out.println("Quiere declarar una variable String");
                        temp = vista.getSetQExpression(expression);
                        valores = new String[]{temp[0], temp[1], "String"};

                        Variable var = new Variable(valores);

                    }else if(vista.isSetQnum(expression)){
                        //TODO que hacer si la variable es un numero
                        //System.out.println("Quiere declarar una variable numerica");
                        temp = vista.getSetQExpression(expression);
                        valores = new String[]{temp[0], temp[1], "int"};

                        Variable var = new Variable(valores);

                    }else if(vista.isSetQbool(expression)){
                        //TODO que hacer si la variable es booleana
                        //System.out.println("Quiere declarar una variable booleana");
                        temp = vista.getSetQExpression(expression);
                        valores = new String[]{temp[0], temp[1], "boolean"};

                        Variable var = new Variable(valores);
                    }
                }

            }else{
                if(vista.isQuote(expression)){
                    vista.removeQuote(expression);
                }

            }

            lineCount += 1;
        }
    }

    public String findAndReplaceVar(String expression){
        String[] names = Variable.variables.keySet().toArray(new String[Variable.variables.size()]);
        for (String name: names) {
            String find = " " + name + " ";
            String replaceBy = " " + Variable.getValue(name) + " ";
            expression = expression.replaceAll(find, replaceBy );
        }

        return expression;
    }


}
