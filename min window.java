class Solution {
    public  static String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m)
        return "";
        else if(n==m && n==1)
        {
            if(s.equals(t))
            return s;
            else
            return "";
        }
        else
        {
            int[]char_count=new int[52];
            int j=0,i=0;
            int count =m;
           
            int beg=0,end=0,min=Integer.MAX_VALUE;
            for(int k=0;k<m;k++)
            {
                char ch=t.charAt(k);
                if(Character.isLowerCase(ch))
                char_count[ch-'a']++;
                else
                char_count[26+ch-'A']++;
            }
            for(int q=0;q<52;q++)
            {
                if(char_count[q]==0)
                char_count[q]=Integer.MIN_VALUE;
            }
            while(j<n )
            {
                char c=s.charAt(j++);
                if(Character.isLowerCase(c) && char_count[c-'a']!=Integer.MIN_VALUE)
                {
                    int a= --char_count[c-'a'];
                    if(a==0)
                    count--;
                }
                if(Character.isUpperCase(c) && char_count[26+c-'A']!=Integer.MIN_VALUE)
                {
                    int a= --char_count[26+c-'A'];
                    if(a==0)
                    count--;
                }
                while(count ==0)
                {
                    if(j-i < min)
                    {
                        beg=i;
                        end=j;
                        System.out.println("beg "+beg+" end"+end);
                    }
                    char ch=s.charAt(i++);
                    if(Character.isLowerCase(ch) && char_count[c-'a']!=Integer.MIN_VALUE)
                    {
                         int a= ++char_count[ch-'a'];
                        if(a>=1)
                        count++;
                    }
                   else if(Character.isUpperCase(ch) && char_count[26+c-'A']!=Integer.MIN_VALUE)
                    {
                        int a= ++char_count[26+ch-'A'];
                        if(a>=1)
                        count++;
                    }
                }
               
            }
            System.out.println("beg: "+ beg);
            if(end-beg>=m)
            return s.substring(beg,end);
            else
            return "";
            
        }
        }
        public static void main(String[] args) {
        String s="aa";
        String t="aa";
        String res=minWindow(s,t); 
        System.out.println(res);   
        }
        
    }
