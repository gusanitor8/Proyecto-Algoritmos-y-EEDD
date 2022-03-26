import java.util.Stack;

public class LogicalPostFix {
	Stack<Integer> stack = new Stack<Integer>();

	/**
	 * Evalua la expresion logica
	 * @param expression expresion logica
	 * @return cadena con el resultado
	 */
	public String operate(String expression){
		String[] tokenized = expression.split(" ");
		
		for(int i = tokenized.length-1; i>= 0; i--){
			try {
				int num = Integer.valueOf(tokenized[i].strip());
				stack.push(num);
				
			}catch(NumberFormatException e){
				if(tokenized[i].strip().equals(">")){
					if(stack.pop() > stack.pop()){
						return("t");
					}else{
						return("nil");
					}
					
			
				}else if(tokenized[i].strip().equals("<")){
					if( stack.pop() < stack.pop()){
						return("t");
					}else{
						return("nil");
					}
					
					
				}else if(tokenized[i].strip().equals("=")){
					if( stack.pop() == stack.pop()){
						return("t");
					}else{
						return("nil");
					}
				}
			}
		}
		return "";
	}
}
	

	