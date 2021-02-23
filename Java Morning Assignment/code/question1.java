package assignment;

public class question1 {
	public static void main(String args[]) {
	    System.out.println(eval("-5+8*6"));
	    System.out.println(eval("(55+9)%9"));
	    System.out.println((int)(eval("20+ -3*5/8")));
	    System.out.println(eval("5+15/3*2-8%3"));
	    
	}
	
public static int eval(final String str) {
	    return new Object() {
	        int pos = -1, ch;

	        void nextChar() {
	            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        boolean select(int charToSelect) {
	            while (ch == ' ') nextChar();
	            if (ch == charToSelect) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        int eval() {
	            nextChar();
	            int x = evalExpression();
	            return x;
	        }
	        
	        int evalExpression() {
	            int x = evalTerm();
	            for (;;) {
	                if      (select('+')) x += evalTerm(); // addition
	                else if (select('-')) x -= evalTerm(); // subtraction
	                else return x;
	            }
	        }

	        int evalTerm() {
	            int x = evalFactor();
	            for (;;) {
	                if      (select('*')) x *= evalFactor(); 
	                else if (select('/')) x /= evalFactor();
	                else if (select('%')) x %= evalFactor(); 
	                else return x;
	            }
	        }

	        int evalFactor() {
	            if (select('+')) return evalFactor(); 
	            if (select('-')) return -evalFactor(); 

	            int x;
	            int startPos = this.pos;
	            if (select('(')) { // parentheses
	                x = evalExpression();
	                select(')');
	            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Integer.parseInt(str.substring(startPos, this.pos));
	            } else {
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            }
	            return x;
	        }
	    }.eval();
	}
}
