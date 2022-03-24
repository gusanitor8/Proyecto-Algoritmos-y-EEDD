import java.util.Scanner;
import java.util.regex.*;

public class Vista {
    Scanner input = new Scanner(System.in);

    private void print(String text){
        System.out.println(text);
    }

    public String display(int lineNum){
        System.out.print("["+lineNum+"]>>");
        return input.nextLine();
    }


    public String rmParentheses(String expression){
        String pattern1 = "[\\(]{1}.*[\\)]{1}";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(expression);
        String palabra = null;

        boolean matchFound = matcher.find();
        if(matchFound){
            palabra = matcher.group();
            palabra = palabra.substring(1 , palabra.length() - 1);
        }

        return palabra;
    }
}
