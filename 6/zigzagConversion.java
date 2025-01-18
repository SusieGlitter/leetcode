class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String ret = new String();
        int delta = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += delta) {
                ret += s.charAt(j);
                int mid=j+delta-2*i;
                if(i!=0&&i!=numRows-1&&mid<s.length()){
                    ret+=s.charAt(mid);
                }
            }
        }
        return ret;
    }
}

public class zigzagConversion {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(sol.convert(s, numRows));
    }
}