public class longest_k_unique_char {
    public static int longestkSubstr(String s, int k) {
        int count=0;
        int n=s.length();
        int beg=0,end=0;
        int map[]=new int[26];
        int ans=-1;
        //char[] a=s.toCharArray();
        
        while(end<n)
        {
            if(count<=k)
            {
                char c=s.charAt(end);
                if(map[c-'a']++==0)
                count++;
            }
            if(count >k)
            {
                ans=Math.max(ans,end-beg);
                while(count>k)
                {
                    char c_del=s.charAt(beg);
                    if(--map[c_del-'a']==0)
                    count--;
                    beg++;

                }
            }
            end++;
            
        }
        if(count==k)
        ans=Math.max(ans, end-beg);
        return ans;
    }
    public static void main(String[] args) {
        String s="meayl";
        //String s="aabacbebebe";
        int k=2;
        int ans=longestkSubstr(s,k);
        System.out.println(ans);
    }
    
}
