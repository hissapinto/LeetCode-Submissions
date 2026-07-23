package ValidParentheses;
import java.util.Deque;
import java.util.ArrayDeque;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("\n\n" + s.isValid("[{}]()"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Deque<Character> p = new ArrayDeque<>();

        for(int i = 0; i<s.length(); i++) {
            Character temp = s.charAt(i);
            
            if (temp == '(' || temp == '[' || temp == '{') {
                p.push(temp);
            } else if (p.isEmpty()) {
                return false;
            } else {
                Character prev = p.pop();
                if (temp != closure(prev)) {
                    return false;
                }
            } 
        }

        return p.isEmpty();
    }

    private Character closure(Character open) {
        switch(open) {
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return '}';
        }
    }
}