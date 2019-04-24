class Solution {
    public int getValue(Character a,HashMap<Character, Integer> m){
        return m.get(a);
    }
    public String getRomanDigit(String s, Integer i, HashMap<Character, Integer> m){
        StringBuilder digit = new StringBuilder("");
        digit.append(s.charAt(i));
        
        while(i>0){ 
            if(getValue(Character.valueOf(s.charAt(i-1)),m)<getValue(Character.valueOf(s.charAt(i)),m)){
                digit.insert(0,s.charAt(i-1));
                i--;
                
            }else{
                return digit.toString(); 
            }
        }
        return digit.toString();
    }
    
    public int getNumber(String digit, HashMap<Character, Integer> m){
        int n = digit.length();
        int sum = m.get(digit.charAt(n-1));
        for(int i=digit.length()-2;i>=0;i--){
            int temp = m.get(digit.charAt(i));
            sum-=temp;
        }
        return sum;
    }
    
    public int romanToInt(String s) {
        // CDXC
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        m.put((Character)'I',1);
        m.put((Character)'V',5);
        m.put((Character)'X',10);
        m.put((Character)'L',50);
        m.put((Character)'C',100);
        m.put((Character)'D',500);
        m.put((Character)'M',1000);
        Integer i=s.length()-1;
        int sum = 0;
        while(i>=0){
            String digit = getRomanDigit(s, i, m); // e.g. XC, CD
            i=i-(digit.length());
            sum+=getNumber(digit, m); // XC to 90 and CD to 400
        }
        return sum;
    }
}