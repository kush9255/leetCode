public class atoi {
    public static void main(String[] args) {
        String s = "-4193 with words";
        int res = myAtoi(s);
        System.out.println(res);
    }

    public static int myAtoi(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int ans = 0;
        boolean minus = false;
        int i = 0;

        while (i < n && a[i] == ' ')
            i++;
        if (i >= n)
            return 0;
        if (a[i] == '+')
            i++;
        else if (a[i] == '-') {
            i++;
            minus = true;
        }
        int max_limit = Integer.MAX_VALUE / 10;
        while (i < n && Character.isDigit(a[i])) {
            int digit = a[i++] - '0';

            if (ans > max_limit || (ans == max_limit && digit>7))
                return (minus) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ans = ans * 10 + digit;
        }
        if (minus)
            ans *= -1;
        return ans;
    }
}
