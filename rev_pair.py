class Solution:
    def countRevPairs(self, N,a):
        return self.countPairs(a,0,len(a)-1)
        # Code here
    
    def countPairs(self,a,beg,end):
        if beg<end:
            mid=(beg+end)//2
            l=self.countPairs(a,beg,mid)
            r=self.countPairs(a,mid+1,end)
            t=self.count(a,beg,mid,end)
            return l+r+t
        return 0
    
    def count(self,a,beg,mid,end):
        res=[0]*(end-beg+1)
        ans=0
        i=beg
        j=mid+1
        while j<end+1 and i<mid+1:
            if a[i]>2*a[j]:
                ans+=mid-i+1
            else:
                 i+=1
                 continue
            j+=1
        
        i,j,k=beg,mid+1,0
        while i<mid+1 and j< end+1:
            if a[i]<a[j]:
                res[k]=a[i]
                i+=1
            else:
                res[k]=a[j]
                j+=1
            k+=1
        
        while i<mid+1:
            res[k]=a[i]
            k+=1
            i+=1
            
        
        while j<end+1:
            res[k]=a[j]
            k+=1
            j+=1
            
        i=beg
        for k in range(0,end-beg+1):
            a[i]=res[k]
            i+=1
        
        return ans
    
arr=[3,2,4,5,1,20]
N=5
ob=Solution()
res=ob.countRevPairs(N,arr)
print(res)