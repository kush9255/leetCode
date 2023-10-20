public class zero_one_two {
    public static void sort012(int a[], int n) {
        int beg=0,end=n-1;
        int i=0;
        while(i<=end) {
            if (a[i] == 0) {
                swap(a, beg, i);
                beg++;i++;
            }
            if (a[i] == 2) {
              swap(a,end,i);  
              end--;
            }
            if(a[i]==1) i++;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = { 1, 0, 1, 0, 0, 1, 2, 0 };
        sort012(a, a.length);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
