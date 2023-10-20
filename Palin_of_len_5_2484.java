public class Palin_of_len_5_2484 {
    public int countPalindromes(String s) {
        int mod=(int)(1e9+7);
        int ans=0;
        int len=5;
        for(char a='0';a<='9';a++)
        {
            for(char b='0';b<='9';b++)
            {
                char[]pattern={a,b,'.',b,a};
                long[]dp=new long[len+1];
                dp[len]=1;

                for(int i=0;i<s.length();i++)
                {
                    char ch=s.charAt(i);
                    for(int k=0;k<len;k++)
                        if(pattern[k]==ch || pattern[k]=='.')
                            dp[k]+=dp[k+1];
                }
                ans+=dp[0];
                ans%=mod;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="0000000";
        Palin_of_len_5_2484 sol=new Palin_of_len_5_2484();
        int ans=sol.countPalindromes(s);
        System.out.println(ans);
    }
}
