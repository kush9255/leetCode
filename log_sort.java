/*LEETCODE question 937 */

import java.util.*;
import java.io.*;

public class log_sort {

    public String[] reorderLogFiles(String[] logs) {
        List<String> mod_inp = Arrays.asList(logs);
        Collections.sort(mod_inp, new custom_sort());
        String[] ans = mod_inp.toArray(new String[0]);
        return ans;
    }

    public static void main(String[] args) {
        String[] inp = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        System.out.println(inp);
        log_sort l = new log_sort();
        String[] ans = l.reorderLogFiles(inp);
        System.out.println(ans);
    }
}

class custom_sort implements Comparator<String> {
    public int compare(String S1, String S2) {
        int k1 = getKey(S1);
        int k2 = getKey(S2);
        String key1 = S1.substring(0, k1);
        String val1 = S1.substring(k1 + 1);
        String key2 = S2.substring(0, k2);
        String val2 = S2.substring(k2 + 1);
        boolean n1 = check_num(val1);
        boolean n2 = check_num(val2);

        // string will be greater than number
        /*
         * else if(n1 && n2){
         * return key1.compareTo(key2);  logs are not sorted
         * }
         */
         if (!(n1|| n2)) { 
            if (!val2.equals(val1))
                return val1.compareTo(val2);
            else
                return key1.compareTo(key2);
        }
        else if(!(n1 && n2)){
            //generally it has to be n1-n2 but in case of order inverted go for n2-n1
            // if n1 is number and n2 is string n1-n2 will make n1 smaller but n2-n1 will make n1 greater
            // same goes for n1 is string and n2 is number n1-n2 will be >0 string will be grater 
            //but n2-n1 <0 and string will be smaller

            return val2.compareTo(val1); 
        }
        return 0;
    }

    public int getKey(String s) {
        int idx = s.indexOf(' ');
        return idx;
    }

    public boolean check_num(String s) {
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9')
            return true;
        return false;
    }
}
