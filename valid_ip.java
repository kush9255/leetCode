public class valid_ip {
    public static void main(String[] args) {
        String s="2.3.4.5:";
        String res=validIPAddress(s);
        System.out.println(res);
    }
    public static String validIPAddress(String s) {

        int idx_i4=s.indexOf(".");
        int idx_i6=s.indexOf(":");
        if(idx_i4>0)
        return check_IP4(s);
        /*
         * earlier I used 
         * if (idx<0)
         * return ip6(s)
         * here It didn't occur to me string can even be a blank or can follow neither
         * like "","2.:"
         */
        else if(idx_i6>0)
        return check_IP6(s);
        else
        return "Neither";
    }
    public static String check_IP4(String s){
        /*
         * This is imp as it checks for trailing . or :1.2.3.4. for accounting for . after 4 but if I use 1.2.3.4: it might fail
         * check with leetcode it works as string is splitted as 4: as delimitter is .
         */
        if(s.charAt(s.length()-1)=='.')
        return "Neither";
        String[] inp=s.split("\\."); // very imp as s.split(".") will never work
        if(inp.length !=4) // there I made mistake of > 4
        return "Neither";
        for(int i=0;i<inp.length;i++){
            String p=inp[i];
            if (p.length() == 0 || p.length() > 3)
            return "Neither";
            if(p.length()>1 && p.charAt(0)=='0')
            return "Neither";
            for(char c:p.toCharArray())
            {
                if(!Character.isDigit(c))
                return "Neither";
            }
            int k=Integer.parseInt(p);
            if(k<0 || k> 255)
            return "Neither";
        }
        return "IPv4";
    }
    public static String check_IP6(String s){
       if(s.charAt(s.length()-1)==':')
        return "Neither";
        String[] inp=s.split(":");
        if(inp.length !=8)
        return "Neither";
        for(int i=0;i<inp.length;i++){
            String p=inp[i];
             if(p.length()==0 || p.length() >4)
              return "Neither";
             for(char c:p.toCharArray()){
                 if(!Character.isDigit(c) && (!Character.isLetter(c)))
                  return "Neither";
                  /*
                   * earlier is used 
                   * !Character.isDigit(c) && (c<'a'||c>'f' || c<'A'||c>'F'))
                   * when it came to d it was giving c>F as true thus I have to specifically check for upper and lower 
                   */
                  if (Character.isLetter(c))
                {
                    if(Character.isLowerCase(c) && (c<'a'||c>'f'))
                    return "Neither";
                    if(Character.isUpperCase(c) && (c<'A'||c>'F'))
                    return "Neither";
                }
             }
        }
        return "IPv6";
    }
}
