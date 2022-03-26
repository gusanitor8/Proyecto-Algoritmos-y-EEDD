import java.util.HashMap;

/**
 * NOTA: Los getters no se documentaron porque se encontro redundante hacerlo
 */
public class Func {
    private String name;
    private String parameters;
    private String paramNum;
    private String predicate;
    private static HashMap<String, Func> funciones = new HashMap<String, Func>();

    /**
     * Metodo constructor
     * @param name nombre de la funcion
     * @param parameters parametros de la funcion
     * @param predicate instrucciones a ejecutar
     */
    public Func(String name, String parameters, String predicate){
        this.name = name;
        this.parameters = parameters;
        this.paramNum = countVars(parameters);
        this.predicate = predicate;

        funciones.put(name,this);
    }

    /**
     * Cuenat el numero de variables en una expresion
     * @param vars las variables de la funcion
     * @return String
     */
    private String countVars(String vars){
        int counter = 0;
        for(int i = 0; i < vars.length(); i++){
            if(vars.charAt(i) != ' '){
                counter++;
            }
        }
        String count = String.valueOf(counter);
        return count;
    }

    public static boolean isInMap(String expression){
        return funciones.containsKey(expression);
    }

    public static Func getFunc(String name){
        return funciones.get(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getParamNum() {
        return paramNum;
    }

    public void setParamNum(String paramNum) {
        this.paramNum = paramNum;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }
}
