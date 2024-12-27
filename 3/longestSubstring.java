class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] bin = new int[128];
        int i=0, j=0, max=0;
        for(;j<s.length();j++)
        {
            bin[s.charAt(j)]++;
            if(bin[s.charAt(j)]>1)
            {
                do
                {
                    bin[s.charAt(i)]--;
                    i++;
                }
                while(s.charAt(i-1)!=s.charAt(j));
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}

public class longestSubstring {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "pwwkew";
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}