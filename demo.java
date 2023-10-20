import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class demo {
    public static String smallestString(String s) throws IOException{
        FileWriter myWriter = new FileWriter("result.txt");
        int n = s.length();
        int i = 0;
        char[] A = s.toCharArray();
        while (i < n && s.charAt(i) == 'a')
        {
            myWriter.write(i+" "+s.charAt(i)+"\n");
            i++;
        }
        if (i == n)
            A[n - 1] = 'z';
        while (i < n && s.charAt(i) != 'a')
        {
            myWriter.write(i+" "+(char)(s.charAt(i)-1)+"\n");
            --A[i++];
        }
        return String.valueOf(A);

    }
    public static void main(String[] args) throws IOException {
        File f=new File("input1.txt");
        Scanner sc=new Scanner(f);
        String a=sc.nextLine();
        String res=smallestString(a);
        FileWriter myWriter1 = new FileWriter("result1.txt");
        myWriter1.write(res);

    }
}
