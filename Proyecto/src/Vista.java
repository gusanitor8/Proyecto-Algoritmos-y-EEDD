import java.util.Scanner;
import java.util.regex.*;

public class Vista {
    Scanner input = new Scanner(System.in);

    private void print(String text){
        System.out.println(text);
    }

    /**
     * Despliega al usuario el numero de linea en la consola
     * @param lineNum numero de linea en la consola
     * @return devuelve el texto que escribio el usuario en la consola
     */
    public String display(int lineNum){
        System.out.print("["+lineNum+"]>>");
        return input.nextLine();
    }

    /**
     * Devuelve al usuario la expresion sin parentesis
     * @param expression cadena de texto encerrada en parentesis
     * @return devuele la cadena sin los parentesis de los extremos
     */
    public String rmParentheses(String expression){
        String pattern1 = "[\\(]{1}.*[\\)]{1}";
        Pattern pattern = Pattern.compile(pattern1, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);
        String palabra = null;

        boolean matchFound = matcher.find();
        if(matchFound){
            palabra = matcher.group();
            palabra = palabra.substring(1 , palabra.length() - 1);
        }

        return palabra;
    }

    /**
     * Verifica que la expresion comience con parentesis
     * @param expression expresion puesta por el usuario
     * @return bandera que indica si tiene parentesis
     */
    public boolean hasParentheses(String expression){
        String pattern1 = "^[\\(]{1}.*[\\)]{1}$";
        Pattern pattern = Pattern.compile(pattern1, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);

        return matcher.find();
    }

    /**
     * funcion para verificar si una expresion es de tipo aritmetico
     * @param expression la expresion dada por el usuario SIN PARENTESIS
     * @return bandera que indica si la expresion es una operacion aritmetica
     */
    public boolean isArthmetic(String expression){
        boolean isArithmetic = false;

        if (checkString(expression) == false){
            String pattern1 = "[\\+\\^\\*/\\-=<>]+";
            Pattern pattern = Pattern.compile(pattern1, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(expression);

            isArithmetic = matcher.find();
        }

        return isArithmetic;
    }

    /**
     * Revisa si la expresion es una cadena de texto (ingresada SIN PARENTESIS)
     * @param expression expresion ingresada por el usuario SIN PARENTESIS
     * @return devuelve una bandera que indica si es una string o no
     */
    public boolean checkString(String expression){
        String checkString = "^[\"]{1}.*[\"]{1}$";
        Pattern pattern = Pattern.compile(checkString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);

        return matcher.find();
    }

    public boolean isSetQ(String expression){
        String setQString = "^[ ]*setq[ ]+[A-Za-z]{1}.*[ ]+.+$";
        Pattern pattern = Pattern.compile(setQString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);

        return matcher.find();
    }

    public boolean isSetQString(String expression){
        String setQString = "^[ ]*setq[ ]+[A-Za-z]{1}.*[ ]+[\"]{1}.*[\"]{1}$";
        Pattern pattern = Pattern.compile(setQString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);

        return matcher.find();
    }

    public boolean isSetQnum(String expression){
        String setQString = "^[ ]*setq[ ]+[A-Za-z]{1}.*[ ]+[0-9]+$";
        Pattern pattern = Pattern.compile(setQString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);

        return matcher.find();
    }

    public boolean isSetQbool(String expression){
        boolean isQuote = false;

        String parentheses = "^[ ]*setq[ ]+[A-Za-z]{1}.*[ ]+[t]{1}$";
        String noParentheses ="^[ ]*setq[ ]+[A-Za-z]{1}.*[ ]+nil$" ;

        Pattern pattern = Pattern.compile(parentheses, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);

        Pattern pat = Pattern.compile(noParentheses, Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(expression);

        if (matcher.find()||mat.find()){
            isQuote = true;
        }
        return isQuote;
    }



    public String[] getSetQExpression(String expression){
        String[] values = null;
        if(isSetQ(expression)){
            expression = expression.strip();

            values = expression.split(" ");

            String last = values[2];

            if(checkString(last)){          //revisa si el valor es una cadena

                last = last.substring(1 , last.length() - 1);
                values[2] = last;
            }
            values = new String[]{values[1], values[2]};
        }
        //TODO arreglar el problema del double quotation mark
        return values;
    }


    public boolean isQuote(String expression){
        boolean isQuote = false;

        String parentheses = "^[']{1}[(]{1}.*[)]{1}$";
        String noParentheses ="^[']{1}.*" ;

        Pattern pattern = Pattern.compile(parentheses, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);

        Pattern pat = Pattern.compile(noParentheses, Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(expression);

        if (matcher.find()||mat.find()){
            isQuote = true;
        }
        return isQuote;
    }

}
