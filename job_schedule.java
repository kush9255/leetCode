import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class job_schedule {
    static int[] JobScheduling(Job a[], int n) throws IOException {
        FileWriter w = new FileWriter("job1.txt");
        Arrays.sort(a,
                (j1, j2) -> (j1.profit != j2.profit) ? (j1.profit - j2.profit) : (j1.deadline - j2.deadline));

        for (int i = n - 1; i >= 0; i--)
            w.write("(" + a[i].deadline + "," + a[i].profit + ") ");
        w.write("\n");

        int[] res = new int[n + 1];

        // for (int i = 0; i <= curr.deadline; i++)
        // w.write(res[i].profit + " ");
        // System.out.println();

        int cnt = 0;
        int ans = 0;
        ArrayList<Integer>l=new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            w.write("i "+a[i].deadline + ":->");
            for (int j = a[i].deadline; j >= 1; j--) {
                w.write("j "+j+" "+res[j]+" "+a[i].profit);
                if (res[j] == 0) {
                    cnt++;
                    ans += a[i].profit;
                    res[j]=a[i].profit;
                    l.add(res[j]);
                    break;
                }
            }
            w.write("\n");
        }
        for(int x:l)
        w.write(x+" ");
        w.write("\n");
        int[] f = new int[2];
        f[0] = cnt;
        f[1] = ans;
        w.write("\n" + f[0] + " " + f[1]);
        w.close();
        return f;
        // Your code here
    }

    public static void main(String[] args) throws IOException {
        try {
            File f1 = new File("job.txt");
            Scanner sc = new Scanner(f1);
            int n = sc.nextInt();
            Job[] a = new Job[n];
            for (int k = 0; k < n; k++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                a[k] = new Job(x, y, z);
            }
            int[] ans = JobScheduling(a, a.length);
            System.out.println(ans[0] + " " + ans[1]);
            sc.close();
        } catch (IOException e) {
            // System.out.println("An IOException occurred: " + e.getMessage());

            // If you want to check for specific subtypes of IOException:
            if (e instanceof FileNotFoundException) {
                System.out.println("File not found.");
            } else if (e instanceof EOFException) {
                System.out.println("End of file reached unexpectedly.");
            }
        }
    }
}
