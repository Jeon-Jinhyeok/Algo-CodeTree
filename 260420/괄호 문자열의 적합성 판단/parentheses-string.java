import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){

            char c = str.charAt(i);

            if(c == '(') stack.push('(');

            else{
                if(stack.isEmpty() || stack.peek() != '('){
                    System.out.println("No");
                    break;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty())
            System.out.println("No");
        else
            System.out.println("Yes");
    }
}