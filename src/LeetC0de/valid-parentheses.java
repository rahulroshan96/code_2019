class Solution {
    public boolean mypop(Stack<Character> mystack, Character c){
        
        if((mystack.peek()=='[' && c==']') || (mystack.peek()=='(' && c==')')|| (mystack.peek()=='{' && c=='}')){
            mystack.pop();
            return true;
        }else{
            return false;
        }
    }
    public boolean isValid(String s) {
        
        if(s.length()==0) return true;
        if(s.length()==1) return false;
        if(s.charAt(0) == ')' || s.charAt(0) =='}' || s.charAt(0) == ']') return false;
        Stack<Character> mystack = new Stack<>();
        int i = 0;
        mystack.push(Character.valueOf(s.charAt(i)));
        i++;
        while(i<s.length()){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){ // push
                mystack.push(Character.valueOf(s.charAt(i)));
                i++;
            }else{
                if(mystack.empty()) return false;
                if(mypop(mystack, Character.valueOf(s.charAt(i)))){
                    i++;
                }else{
                    return false;
                }
            }
        }
        if(!mystack.empty()){
            return false;
        }else{
            return true;
        }
    }
}