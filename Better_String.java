import java.util.Arrays;

public class Better_String {
        static int[] ans_map;
    public static String betterString(String str1, String str2) {
        
        int n1=subSequence(str1,0,str1.length(),new int[26]);
        int n2= subSequence(str2,0,str2.length(),new int[26]);
        //System.out.println(n1+" "+n2);
        if(n1>=n2)
        return str1;
        
        return str2;
    }
    static int subSequence(String str,int i,int n,int[] map)
    {
        Arrays.fill(map,-1);
        int ans=0;
        ans_map=new int[n+1];
        if(i==n)
        {
        ans_map[i]=1;
        return 1;
        }
        
  
        int aux=subSequence(str,i+1,n,map);
        char ch=str.charAt(i);
       if(map[ch-'a']==-1)
        ans=2*aux;
        else
        ans=2*aux-ans_map[map[ch-'a']+1];
        map[ch-'a']=i;
        ans_map[i]=ans;
        return ans;
    }
    public static void main(String[] args) {
        String s1="xqjcqsuw";
        String s2="ysbxnbjv";
       // System.out.println(s1.length()+" "+s2.length());
        String ans=betterString(s1, s2);
        System.out.println(ans);
    }
}
