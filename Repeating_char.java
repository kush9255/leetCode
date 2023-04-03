/*
 * Leetcode Q-316 very imp wrt stringbuilder
 */

import java.util.*;

class Repeating_char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = "cbacdcbc";
        String res = removeDuplicateLetters(inp);
        System.out.println(res);

    }

    public static String removeDuplicateLetters(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("");

        boolean[] cmap = new boolean[26];
        for (int i = 0; i < 26; i++)
            cmap[i] = false;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int c = map.get(ch);
            map.put(ch, c - 1);
            if (count < 0 || sb.charAt(count) < ch && cmap[ch - 'a'] == false) {
                sb.append(ch);
                count++;
                cmap[ch - 'a'] = true;
            } else {
                while (count >= 0 && sb.charAt(count) > ch && map.get(sb.charAt(count)) != 0 && !cmap[ch - 'a']) {
                    cmap[sb.charAt(count) - 'a'] = false;
                    sb.deleteCharAt(count);
                    count--;
                }
                if (!cmap[ch - 'a']) {
                    sb.append(ch);
                    count++;
                    cmap[ch - 'a'] = true;
                }
            }

        }
        return sb.toString();
    }

}