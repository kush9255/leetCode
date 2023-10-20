public class flips{
    public static int minFlips(String S) {
        int p=S.length();
        char[]s=S.toCharArray();
        char nxt=s[p-1];
        int i=p-2;
        int ans=0;
        
        if(p==1) return 0;
        if(p==2)
        {
            return (s[0]==s[1])?1:0;
        }
        int c0=0;
        int c1=0;
        
        while(i-1>=0)
        {
            char curr=s[i];
            if(curr==nxt)
            {
                int k=curr-'0';
                char pre=s[i-1];
                if(pre == curr)
                {
                curr=(char)('0'+Math.abs(k-1));
                s[i]=curr;
                if(s[i]==0)c0++;
                else c1++;
                ans++;
                }
                else
                {
                s[i+1]=s[i];
                ans++;
                if(s[i+1]=='0')c0++;
                else c1++;
                }
            }
            else
            {
                char pre=s[i-1];
                if(pre == curr)
                {
                s[i-1]=nxt;
                if(s[i-1]==0)c0++;
                else c1++;
                ans++;
                }
            }
            nxt=s[i--];
        }
        System.out.println(new String(s));
        return ans;
        
        // Co;de here
    }
    public static void main(String[] args) {
        String s="000000000111111111111111111";
        int ans=minFlips(s);
        System.out.println(ans);

    }
}