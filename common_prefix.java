/*
 * Q: 14. Very important that we are looking for prefix it should start from index 0
 * we leveaged this as indexOf("prefix") if exists will yield 0
 * if not keep reducing it and when string length reduces to 0 return
 */

public class common_prefix {
    public static void main(String[] args) {
        String[] inp={"flower","flow","flight"};
        String ans=findPrefix(inp);
        System.out.println(ans);
    }

    public static String findPrefix(String[] a) {
        if (a.length == 0)
            return "";
        int n = a.length;
        String prefix = a[0];
        for (int i = 1; i < n; i++) {
            int lim=a[i].indexOf(prefix);
            while ( lim != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
                lim=a[i].indexOf(prefix);    
            }
        }
        return prefix;
    }
}

