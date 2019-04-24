class Solution {
    public String commonString(String s1, String s2){
        int n = Math.min(s1.length(), s2.length());
        StringBuilder s = new StringBuilder("");
        for(int i=0;i<n;i++){
            if(s1.charAt(i) == s2.charAt(i)){
                s.append(s1.charAt(i));
                // i++;
            }else{
                return s.toString();
            }
        }
        return s.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        String result = new String("");
        if(strs.length==0) return "";
        result = strs[0];
        // result.append(strs.get(0));
        for(int i=1;i<strs.length;i++){
            String temp = commonString(result,strs[i]);
            // System.out.println(temp);
            if(temp.length()==0){
                return "";
            }else{
                result = temp;
            }
        }
        return result;
    }
}