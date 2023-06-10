vector<long long int>dp(arr.size()+1,0);
        long long int n=arr.size();
        for(long long int ind=n-1;ind>=0;ind--)
        {
        long long int maxi=long long int_MIN;
        long long int fmax=long long int_MIN;
        long long int length=0;
        long long int n=arr.size();
        long long int l=min(n,ind+k);
        for(long long int j=ind;j<l;j++)
        {
            length++;
            maxi=max(maxi,arr[j]);
            long long int sum=length*maxi+dp[j+1];
            fmax=max(fmax,sum);
        }
         dp[ind]=fmax;
        }
        return dp[0];