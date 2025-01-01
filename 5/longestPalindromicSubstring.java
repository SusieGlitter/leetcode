class Solution {
    static long b=133,m=100000007;
    public long hash1(int s,int t,long[] prev,long[] bpow){
        if(s==0)
            return prev[t];
        return ((prev[t]-prev[s-1]*bpow[t-s+1])%m+m)%m;
    }
    public long hash2(int s,int t,long[] suff,long[] bpow){
        if(t==suff.length-1)
            return suff[s];
        return ((suff[s]-suff[t+1]*bpow[t-s+1])%m+m)%m;
    }
    public String longestPalindrome(String s) {
        long[] prev=new long[s.length()],suff=new long[s.length()],bpow=new long[s.length()];

        prev[0]=s.charAt(0);
        for(int i=1;i<s.length();i++)
            prev[i]=(prev[i-1]*b+s.charAt(i))%m;
        
        suff[s.length()-1]=s.charAt(s.length()-1);
        for(int i=s.length()-2;i>=0;i--)
            suff[i]=(suff[i+1]*b+s.charAt(i))%m;
        
        bpow[0]=1;
        for(int i=1;i<s.length();i++)
            bpow[i]=(bpow[i-1]*b)%m;

        int max1=0;
        int center1=0;
        for(int i=0;i<s.length();i++)
            while((i-max1>=0)&&(max1+i<s.length())&&(hash1(i-max1,i,prev,bpow)==hash2(i,max1+i,suff,bpow)))
            {
                max1++;
                center1=i;
                // ret1=s.substring(i-max1+1, max1+i);
            }
        int max2=0;
        int center2=0;
        for(int i=0;i<s.length();i++)
            while((i-max2>=0)&&(max2+i+1<s.length())&&(hash1(i-max2,i,prev,bpow)==hash2(i+1,max2+i+1,suff,bpow)))
            {
                max2++;
                center2=i;
                // ret2=s.substring(i-max2+1, max2+i+1);
            }
        return (max1>max2)?s.substring(center1-max1+1, max1+center1):s.substring(center2-max2+1, max2+center2+1);
    }
}

public class longestPalindromicSubstring {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aaaaaaaaaaaaaaaaaa";
        System.out.println(sol.longestPalindrome(s));
    }
}
