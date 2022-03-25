import java.util.stack;

public class LogicalPostFix {
	Stack<Integer> stack = new Stack<Integer>();
	
	public LogicalPostFix(String Expression){	
		String[] tokenized = expression.split( regex: "");
		
		For(int i = tokenized.length-1; i>= 0; i--){
			try {
				int num = Integer.valueOf(tokenized[i].strip());
				stack.push(num);
				
			}catch(NumberFormatException e){
				if(tokenized[i].strip().equals(">")){
					if(stack.pop() > stack.pop()){
						System.out.printin("t");
					}else{
						System.out.printin("nil");
					}
					
			
				}else if(tokenized[i].strip().equals("<")
					if( stack.pop() < stack.pop()){
						System.out.printin("t");
					}else{
						System.out.printin("nil");
					}
					
					
				}else if(tokenized[i].strip().equals("=")
					if( stack.pop() == stack.pop()){
						System.out.printin("t");
					}else{
						System.out.printin("nil");
					}
				
				}
			}
		}
	}
	
	public static void main(Strings[] args){
	