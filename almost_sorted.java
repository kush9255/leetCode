import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> a) {
        int n=a.size();
        int beg=-1,end=-1;
        boolean sorted=true;
        for(int i=0;i<n-1;i++){
            if(a.get(i)>a.get(i+1)){
                beg=i;
                sorted=false;
                break;
            }
        }
        if(sorted)
        {
        System.out.println("no");
        return;
        }
        for(int i=n-1;i>beg;i--){
            if(a.get(i)<a.get(beg))
            {
                end=i;
                break;
            }
        }
        check(a,beg,end);

    }
    public static void reverse(List<Integer> a,int beg,int end){
        while(beg<end){
            exchange(a,beg,end);
            beg++;
            end--;
        }
        
    }
    public static void exchange(List<Integer> a,int beg,int end){
        int temp=a.get(beg);
        a.set(beg,a.get(end));
        a.set(end,temp);
    }
    public static void check(List<Integer> a,int beg,int end){
        int j=end, i=beg;
        boolean reverse=true;
        boolean swap=false;
        boolean sorted=true;
        while(j>i)
        {
            if(a.get(j)<a.get(j-1))
            j--;
            else{
                reverse=false;
                break;
            }
        }
        
        //check after swapping
        if(reverse == true)
        {
            if(end-beg==1){
            swap=true;
            exchange(a,beg,end);
            }
            else
            reverse(a,beg,end);
        }
        else{
        exchange(a,beg,end);
        swap=true;
        }
        for(int k=0;k<a.size()-1;k++)
        {
            if(a.get(k)>a.get(k+1))
            {
                sorted=false;
                break;
            }
        }
        if(!sorted)
        System.out.println("no");
        else{
            if(swap)
            {
            System.out.println("yes");
            System.out.println("swap "+(beg+1)+" "+(end+1));
            }
            else if(reverse){
            System.out.println("yes");
            System.out.println("reverse "+(beg+1)+" "+(end+1));
            }
        }
    }

}

public class almost_sorted {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
