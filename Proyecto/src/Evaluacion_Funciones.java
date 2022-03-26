
/**
 * @author Manuel Rodas
 * @author Diego Valdez 
 * @author Gustavo Gonzales
 *
 */


//import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import java.util.List;
import java.util.ArrayList;



public class Evaluacion_Funciones {

    /**
     *
     * @param values
     * @return
     */
    public List<Object> toList(List<Object> values){
        return values;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public boolean isEqual(Object a, Object b){
        return a.equals(b);
    }

    public boolean isLessThan(Object a, Object b){
        return (Double.parseDouble(a.toString()) < Double.parseDouble(b.toString()));
    }
    
    public boolean isGreaterThan (Object a, Object b){
        return (Double.parseDouble(a.toString()) > Double.parseDouble(b.toString()));
    }

	 /**
	 * 
     * @param 
     * @return true
     */
    public boolean isAtom(Object value){
        try {
            if((Integer)Integer.parseInt(value.toString()) instanceof Integer){
                return true;
            }
	} 
        catch (NumberFormatException e) {
            try {
                if((Float)Float.parseFloat(value.toString()) instanceof Float){
                    return true;
                }
            } 
            catch (NumberFormatException e2) {
                try {
                    if((Double)Double.parseDouble(value.toString()) instanceof Double){
                        return true;
                    }
		} 
                catch (NumberFormatException e3) {
                    try{
                        String valor = value.toString();
                        if(valor instanceof String){
                            if(Character.toString(valor.charAt(0)).equals("'")){
                                return true;
                            }
                            return false;
                        }
                    }
                    catch(Exception e4){
                        return false;
                    }
		}
            }
	}
        return false;
    }
    
    
   
    
     
    
    
    
}
