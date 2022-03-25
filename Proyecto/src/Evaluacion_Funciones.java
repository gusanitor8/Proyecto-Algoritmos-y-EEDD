
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
    
    
    
    
    
    
    
    
    // ejemplo de como debe de colocar el usuario =  (cond ((equal 2 2) (+ 1 1)) ((equal 1 3) (+ 1 2)) (t (+ 2 2)))    
    //Se le pasara la primera lista ( ("equal 2 2" , "+ 1 1") , ("equal 1 3" , "+ 1 2") , "t (+ 2 2)"  )    lista instrucciones
    
    
    public Object cond(List condiciones){
        List subList = condiciones.subList(1, condiciones.size());     //Se toma ((equal 1 3) (+ 1 2))) como sublist
        List subList2 = (List) subList.get(0);                        //Se toma (equal 1 3) (+ 1 2)) como subList2
        int i = 0;                                                     //evalua (equal 2 2) (+ 1 1)
        for (Object inst: subList2) {                                
            List instruccion = (List)inst;      //Se plantea la variable "instrucciones" como 
            if (instruccion.contains("equal")){
                if (isEqual(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);                           //devuelve (+ 1 2 )
                }
            } else if (instruccion.contains("<")){
                if (isLessThan(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (instruccion.contains(">")){
                if (isGreaterThan(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (i == subList2.size()){
                return subList2.get(i);
            }
            i++;
        }
        return null;                                               //El resultado de este metodo se debe de volver a evaluar, y debe de pasar por todos los metodos, otra vez 
    }
    
    
    
    
    
    
    
    
    
}
