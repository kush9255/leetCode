import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class combination_sum {
    static ArrayList<ArrayList<Integer>> ans;

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ans = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        Collections.sort(A);
        findCombination(A, 0, B, l, A.size());
        // System.out.println(ans);
        // modify(ans);
        return ans;
    }

    static void findCombination(ArrayList<Integer> a, int i, int sum, ArrayList<Integer> l, int n) {
        if (sum == 0) {
            ArrayList aux = (ArrayList) l.clone();
            ans.add(aux);
            /*
             * if(ans.size()<2)
             * System.out.println(ans);
             * //System.out.print("res"+ l+"\n");
             */
            return;
        }
        if (sum < 0 || i == n)
            return;

        if (i + 1 == n || a.get(i) != a.get(i + 1)) {
            l.add(a.get(i));
            findCombination(a, i, sum - a.get(i), l, n);
            l.remove(l.size() - 1);
            findCombination(a, i + 1, sum, l, n);
        } else
            findCombination(a, i + 1, sum, l, n);
    }

    static void modify(ArrayList<ArrayList<Integer>> a) {
        for (ArrayList<Integer> aux : a)
            Collections.sort(aux);

        Collections.sort(a, (b1, b2) -> {
            return b2.size() - b1.size();

        });
    }
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(8,1,8,6,8));
        int B=12;
        combinationSum(A,B);
        System.out.println(ans);
    }
}
