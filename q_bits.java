public class q_bits {
    static int reduce(int a,int b){
        if(a<b)
        return a;
        int k=(int)(Math.log(a)/Math.log(2))+1;
        k=1<<k;
        for(int i=k;i!=0;i>>=1)
        {
            int x=i&a;
            int y=i&b;
            if(x>y)
            {
                int ans=(~i&a);
                if(ans<b)
                return ans;
                a=ans;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int x=13;
        int y=10;
        int ans=reduce(x,y);
        System.out.println(ans);
    }
    
}
