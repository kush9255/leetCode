public class wiggle_sort {
    public static void main(String[] args) {
        int[]a={1,3,2,2,3,1};
        wiggleSort(a);
        for(int i:a)
        System.out.print(i+" ");
    }
    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int left = 0, right = n - 1, i = 0;
        while (i <= right) {
            int new_i=newIndex(i, n);
            if (nums[new_i] > median) {
                int new_left=newIndex(left++, n);
                swap(nums, new_left, newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                int new_right=newIndex(right--, n);
                swap(nums, new_right, newIndex(i, n));
            } else {
                i++;
            }
        }
    }
    
    public static int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
    
    public static int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            } else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }
    
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left-1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, right);
        return i+1;
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
