public class wild_card {
    public static boolean isMatch(String a, String b) {
        int n=a.length();
        int m=b.length();
        boolean[]pre=new boolean[n+1];
        pre[0]=true;

        for(int i=1;i<=m;i++)
        {
            char c=b.charAt(i-1);
            boolean[]curr=new boolean[n+1];
            if(c=='*')
            curr[0]=pre[0];
            for(int j=1;j<=n;j++)
            {
                char d=a.charAt(j-1);
                if(c==d || c=='?')
                curr[j]=pre[j-1];
                if(c=='*')
                curr[j]=pre[j-1]||curr[j-1]||pre[j];
            }
            pre=curr;
        }

        
        return pre[n];
    }
    public static void main(String[] args) {
        String a="*?";
        String b="b";
        boolean ans=isMatch(a,b);
        System.out.println(ans);
    }
}
