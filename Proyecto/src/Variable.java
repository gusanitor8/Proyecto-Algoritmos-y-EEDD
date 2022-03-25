import java.util.ArrayList;

public class Variable {
    static ArrayList<Variable> variables;
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
        this.valores = values;

        variables.add(this);

        //TODO verificar si la variable existe dentro del array, si si cambiar los valores, si no agregarla como nueva

    }

    public Variable setq(String name, String value){


        return null;
    }

}
