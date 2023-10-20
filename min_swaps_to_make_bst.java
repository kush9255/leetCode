import java.util.Arrays;
import java.util.Stack;

class Pair implements Comparable<Pair> {
    int i;
    int idx;

    Pair(int i, int idx) {
        this.i = i;
        this.idx = idx;
    }

    public int compareTo(Pair p) {
        return this.i - p.i;
    }
}

public class min_swaps_to_make_bst {
    static int[] inorder;
    static int cnt;

    public static int minSwaps(int[] A,int n) {
        inorder = new int[n];
        cnt = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        inOrder(A, st, n);

        // for(int i=0;i<n;i++)
        // System.out.print(inorder[i]+" ");

        Pair[] orig = new Pair[n];

        for (int i = 0; i < n; i++) {
            orig[i] = new Pair(inorder[i], i);
        }

        Arrays.sort(orig);

        return minCount(orig, n);
    }

    public static int minCount(Pair[] a, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Pair p = a[i];
            while (i != p.idx) {
                swap(a, i, p.idx);
                p = a[i];
                ans++;
            }
        }
        return ans;
    }

    public static void swap(Pair[] arr, int i, int j) {
        Pair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void inOrder(int[] a, Stack<Integer> st, int n) {
        if (st.size() == 0)
            return;

        int idx = st.peek();

        if (2 * idx + 1 < n) {
            st.push(2 * idx + 1);
            inOrder(a, st, n);
        }
        idx = st.pop();
        inorder[cnt++] = a[idx];
        if (2 * idx + 2 < n) {
            st.push(2 * idx + 2);
            inOrder(a, st, n);
        }
    }
    public static void main(String[] args) {
        int[] a={5,6,7,8,9,10,11};
        int ans =minSwaps(a,a.length);
        System.out.println(ans);
    }
}

