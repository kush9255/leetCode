public class minimum_coins {
    public static int coinChange(int[] coins, int sum) {
        if (sum == 0)
            return 0;
        int n = coins.length;
        int[] rear = new int[sum + 1];
        int max = (int) 1e9 + 7;
        for (int i = 0; i < sum + 1; i++)
            if (i % coins[0] == 0)
                rear[i] = i / coins[0];
            else
                rear[i] = max;

        for (int i = 1; i < n; i++) {
            int[] front = new int[sum + 1];
            for (int j = 0; j < sum + 1; j++) {
                front[j] = rear[j];
                if (j >= coins[i])
                    front[j] = Math.min(front[j], 1 + front[j - coins[i]]);
            }
            rear = front;
        }

        return (rear[sum] >= max) ? -1 : rear[sum];

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int sum = 4;
        int ans = coinChange(coins, sum);
        System.out.println(ans);
    }
}
