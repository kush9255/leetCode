/*
 * each element occurs twice and one occurs 1
 */
class single_in_sorted {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length - 1;
        int res = -1;
        res = findno(nums, 0, n, n + 1);
        return res;
    }

    public int findno(int[] a, int start, int end, int len) {
        int ans = -1;
        if (start < end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && mid + 1 < len && a[mid] != a[mid + 1] && a[mid] != a[mid - 1])
                return a[mid];
            else {
                /*
                 * this keeps track of count if have to ensure our array has odd no. of elements
                 * suppose till my mid elements are even
                 * case 1 its partner is in left side then gp to 
                 */
                if ((mid - start) % 2 == 0) {// this means ODD no of elements 
                    if (a[mid + 1] == a[mid]) // my current element is what making this odd then 
                        ans = findno(a, mid, end, len);// in we have break from mid as mid,mid+1 will make it even
                    else // here my element is even and odd is in left array thus end at mid
                        ans = findno(a, start, mid, len);
                } else {// if have EVEN elements
                    if (a[mid + 1] == a[mid])//my pair is in right then one odd makes it even thus mid-1
                        ans = findno(a, start, mid - 1, len);
                    else//mid+1 as till mid all are even as my pair is in left
                        ans = findno(a, mid + 1, end, len);
                }
            }
        } else
            return a[start];

        return ans;
    }
}