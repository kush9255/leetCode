class Solution:
    def lenOfLongSubarr (self, a, n, k) :
        map={}
        sum=0
        ans=0
        for i in range(n):
            sum+=a[i]
            if(sum==k):
                ans=max(ans,i+1)
            elif (sum-k) in map:
                reqd=sum-k
                aux_ans=i-map[sum-k]
                ans=max(ans,aux_ans)
            if sum not in map:
                map[sum]=i
        return ans
    
l=[8,-9,10,-2,-10,6,18,17]
n=8
k=17
ob=Solution()
print(ob.lenOfLongSubarr(l,n,k))