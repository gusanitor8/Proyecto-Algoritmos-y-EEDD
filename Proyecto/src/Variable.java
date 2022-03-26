import java.util.ArrayList;
import java.util.HashMap;

/**
 * NOTA: Los getters no se documentaron porque se encontro redundante hacerlo
 */
public class Variable {
    static HashMap<String, String[]> variables = new HashMap<String, String[]>();

    private String name;
    private String type;
    private String value;
    private String[] valores;

    /**
     * metodo constructor de variable
     * @param values
     */
    public Variable(String[] values){
        this.name = values[0];
        this.value = values[1];
        this.type = values[2];
        this.valores = new String[]{value, type};

        variables.put(name, valores);

        System.out.println(value);
    }


    public String getValue(){
        String value = variables.get(name)[0];
        return value;
    }

    public static String getValue(String name){
        String value = variables.get(name)[0];
        return value;
    }

    public String getType(){
        String type = variables.get(name)[1];
        return type;
    }

    public static String getType(String name){
        String type = variables.get(name)[1];
        return type;
    }

}
