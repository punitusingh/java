package algorithm.stack;

import java.util.HashMap;
import java.util.Map;

public class BalancedBrackets {

    static Map<Character,Character> bracketMap=new HashMap<>();

    static {
        bracketMap.put('(',')');
        bracketMap.put('{','}');
        bracketMap.put('[',']');
    }


    public static String checkBalance(String input){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<input.length();i++){
            Character current=input.charAt(i);
            if(bracketMap.containsKey(current)){
                stack.push(current);
            }else if(current != bracketMap.get(stack.pop())){
                return "NO";
            }
        }

        if(stack.isEmpty()){
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(checkBalance("{{}}{}(){([[{}([]{})]])}"));
    }

}
