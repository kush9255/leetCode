public class Transform_adding_in_front {
    static int transform(String A, String B) {
        int[] map = new int[58];
        int n = A.length();
        int m = B.length();
        if (n != m)
            return -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (map[A.charAt(i) - 'A'] == 0)
                count++;

            map[A.charAt(i) - 'A']++;
        }

        for (int j = 0; j < n; j++) {
            if (map[B.charAt(j) - 'A'] == 0)
                return -1;
            --map[B.charAt(j) - 'A'];
            if (map[B.charAt(j) - 'A'] == 0)
                count--;
        }

        if (count != 0)
            return -1;

        int i = n - 1;
        int j = n - 1;
        while (i >= 0) {
            if (A.charAt(i) != B.charAt(j)) {
                // System.out.println(A.charAt(i)+" "+B.charAt(j));
                count++;
            } else
                j--;
            i--;
        }
        return count;
    }
    public static void main(String[] args) {
        String A="GeeksForGeeks";
        String B="ForGeeksGeeks";
        int ans=transform(A,B);
        System.out.println(ans);
    }
}
