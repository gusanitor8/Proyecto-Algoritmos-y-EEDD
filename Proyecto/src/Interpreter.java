import ArithmeticProcessing.Parser;
import ArithmeticProcessing.Postfix;

public class Interpreter {
    Vista vista = new Vista();
    Parser parser = new Parser();
    Postfix postfix = new Postfix();
    LogicalPostFix logic = new LogicalPostFix();

    public void run(String string){
        boolean condition = true;
        int lineCount = 1;
        int counter = 0;


        while (condition){

            String expression = "";
            if(string == null) {
                expression = vista.display(lineCount);
            }else{
                expression = string;
                if(counter>0){
                    condition = false;
                    break;
                }
            }

            if(vista.hasParentheses(expression)){                       //Verifica si tiene parentesis
                expression = vista.rmParentheses(expression);           //Se remueven los parentesis de la expresion

                if(vista.isDefun(expression)){
                    String funcName = vista.getFuncName(expression);
                    String vars = vista.getFuncVars(expression);
                    String predicate = vista.getFuncPredicate(expression);

                    Func func = new Func(funcName,vars,predicate);

                    System.out.println(vista.getFuncName(expression));

                }else if(Func.isInMap(vista.getFirstAtom(expression))){
                    String funcName = vista.getFirstAtom(expression);
                    Func myFunc = Func.getFunc(funcName);
                    String variables = myFunc.getParameters();

                    for(int i = 0; i < variables.length(); i++){
                        if(variables.charAt(i) != ' '){
                            char temp = variables.charAt(i);
                            String input ="(setq "+ temp +" "+ vista.getNAtom(expression,i+1)+")";
                            run(input);
                        }
                    }

                    run(myFunc.getPredicate());
                    System.out.println("I worked??");

                }else if(vista.isArthmetic(expression)) {
                    expression = findAndReplaceVar(expression);
                    String end = postfix.evaluate(parser.stringToQueue(expression));
                    System.out.println(end);

                }else if(vista.isLogicOperation(expression)){
                    expression = findAndReplaceVar(expression);
                    System.out.println( logic.operate(expression));

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
                }else if(expression.equals("exit")){
                    break;

                }else{
                    findAndReplaceVar(expression);
                }

            }else{
                if(vista.isQuote(expression)){
                    vista.removeQuote(expression);
                    System.out.println(expression);
                }

            }

            lineCount += 1;
            counter++;
        }


    }

    public String findAndReplaceVar(String expression){
        String[] names = Variable.variables.keySet().toArray(new String[Variable.variables.size()]);
        for (String name: names) {
            String find =  name;
            String find2 = "[ ]*"+ name + "[ ]*";
            String replaceBy =   Variable.getValue(name) ;
            expression = expression.replaceAll(find, replaceBy );
        }
        expression = expression.strip();

        return expression;
    }


}
