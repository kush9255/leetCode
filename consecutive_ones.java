public class consecutive_ones {
     public int longestOnes(int[] a, int k) {
        int count=k;
        int beg=0;
        int end=0;
        int n=a.length;
        int i=0;
        int ans=Integer.MIN_VALUE;
        while(beg<n)
        {
            count=k;
            int temp1=0;
            int temp2=0;
    
           while(beg<n && a[beg]==0)
           {
               beg++;end++;
           }
           if(beg==n)
           break;
           while(end+1<n && a[end+1]==1)
           end++;

           int end1=(end+1<n)?end+1:n-1;
           int beg1=(beg-1>-1)?(beg-1):0;
           
           while(beg1-1>-1 && a[beg1-1]==0)
           beg1--;
           
           while(end1+1<n && a[end1+1]==0)
           end1++;
           
           int left=beg-beg1;
           
           int right=end1-end;
           
           beg1=beg;end1=end;
         //case 1 both count >k
         if(left>k && right >k)
         {
             end1=end+k;
             ans=Math.max(ans,end1-beg+1);
         }
         else if(left>k && right<=k)
         {
             //probe right
            count-=right;
            end1=end;
            while(right!=0 && end1+1<n)
            {
                if(a[end1]==0)
                {
                    right--;
                }
                if(right==0)continue;
                end1++;
            }
             while(end1+1<n && a[end1+1]==1)
             end1++;
             if(end1>n)
             end1=n-1;
             count=(count<=k)?count:k;
             beg1=beg;
             while(count!=0 && beg1-1>-1)
             {
                if(a[beg1]==0)
                count--;
                if(count==0)continue;
                beg1--;
             }
             while(beg1-1>-1 && a[beg-1]==1)
             beg1--;
             if(beg1<0)
             beg1=0;

           ans=Math.max(end1-beg1+1,ans);
           //System.out.println("ans "+ans);
         }

         else if(left<=k && right>k)
         {
            //probe left;
            count-=left;
            beg1=beg;
            while(left!=0 && beg1-1>-1)
            {
                if(a[beg1]==0)
                {
                    left--;
                }
                if(left==0)continue;
                beg1--;
            }
             while(beg1-1>-1 && a[beg1-1]==1)
             beg1--;
             if(beg1<0)
             beg1=0;

             count=(count<=k)?count:k;
        
             end1=end;

             while(count!=0 && end1+1<n)
            {
                if(a[end1]==0)
                {
                    count--;
                }
                if(count==0)continue;
                end1++;
            }
             while(end1+1<n && a[end1+1]==1)
             end1++;
             if(end1>n)
             end1=n-1;

             ans=Math.max(end1-beg1+1,ans);
         }

         else if(left<=k && right<=k)
         {
             //probe left
             count-=left;
             while(left!=0 && beg1-1>-1)
            {
                if(a[beg1]==0)
                {
                    left--;
                }
                if(left==0)continue;
                beg1--;
            }
             while(beg1-1>-1 && a[beg1-1]==1)
             beg1--;
             if(beg1<0)
             beg1=0;

            end1=end;
            while(count!=0 && end1+1<n)
            {
                if(a[end1]==0)
                {
                    count--;
                }
                if(count==0)continue;
                end1++;
            }
             while(end1+1<n && a[end1+1]==1)
             end1++;
             if(end1>n)
             end1=n-1;
             temp1=(end1-beg1)+1;
            

            //probe right
            count=k;beg1=beg;end1=end;
            count-=right;
            while(right!=0 && end1+1<n)
            {
                if(a[end1]==0)
                {
                    right--;
                }
                if(right==0)continue;
                end1++;
            }
             while(end1+1<n && a[end1+1]==1)
             end1++;
             if(end1>n)
             end1=n-1;
            beg1=beg;
            while(count!=0 && beg1-1>-1)
             {
                if(a[beg1]==0)
                count--;
                if(count==0)
                continue;
                beg1--;
             }
             while(beg1-1>-1 && a[beg-1]==1)
             beg1--;
             if(beg1<0)
             beg1=0;
            temp2=end1-beg1+1;

            ans=Math.max(ans,Math.max(temp1,temp2));
         }
         end++;
         beg=end;
            
        }
        
        if(ans==Integer.MIN_VALUE)
        ans=k;
        return ans;    
    }
    public static void main(String[] args) {
        int[]a={1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        //int[]a={0,0,0,1,1,0,1,1,0,1,1};
        int k=8;
        consecutive_ones c=new consecutive_ones();
        int ans=c.longestOnes(a, k);
        System.out.println(ans);
    }
}
