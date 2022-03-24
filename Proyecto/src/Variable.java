import java.util.ArrayList;

public class Variable {
    static ArrayList<Variable> variables;
    private String name;
    private String type;
    private String value;

    /**
     * Metodo constructor de la clase Variable
     * @param name nombre de la variable
     * @param type
     * @param value
     */
    public Variable(String name, String type, String value){
        this.name = name;
        this.type = type;
        this.value = value;
        String[] data = {name, value, type};

        //TODO verificar si la variable existe dentro del array, si si cambiar los valores, si no agregarla como nueva

    }

    public Variable setq(String name, String value){


        return null;
    }

}
