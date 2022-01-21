package Leetcode.Java_code;

public class longestCommonPrefix {
    public String find(String[] strs){
        if(strs.length == 1) return strs[0];
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                try {
                    if (strs[j].charAt(i) != strs[j - 1].charAt(i))
                        return result.toString();
                }catch (Exception e){
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args){
        quickprint.print(new longestCommonPrefix().find(new String[]{"flower", "flow", "flight"}));
    }
}
