public class buy_sell {
    public static void main (String[] args) {
        int [] a ={886,2777,6915,7793,8335,5386,492,6649,1421,2362,27,8690,59,7763,3926,540,3426,9172,5736,5211,5368,2567,6429,5782,1530,2862,5123,4067,3135,3929,9802,4022,3058,3069,8167,1393,8456,5011,8042,6229,7373,4421,4919,3784,8537,5198,4324,8315,4370,6413,3526,6091,8980,9956,1873,6862,9170,6996,7281,2305,925,7084,6327,336,6505,846,1729,1313,5857,6124,3895,9582,545,8814,3367,5434,364,4043,3750,1087,6808,7276,7178,5788};
        int k=3;
        stockBuySell(a,a.length);
        
        }
        public static void stockBuySell(int[] a, int n) {
            int buy=0,sell=0,i=1;
            for(i=1;i<n;i++)
            {
                if(a[i]>=a[i-1])
                    sell=i;
                else
                {
                if(sell>buy)
                System.out.print("("+buy+" "+sell+") ");
                buy=sell=i;
                }
            }
            if(i==n && sell<n && buy<n && a[sell]>a[buy])
            System.out.print("("+buy+" "+sell+")");
            // code here
        }
}
