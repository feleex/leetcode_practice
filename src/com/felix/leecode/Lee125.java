package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-14 16:18
 */
public class Lee125 {
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println((char)33);
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int start=0,end=s.toCharArray().length-1;
        while (start<end){
            char low=s.charAt(start);
            char high=s.charAt(end);
            while (!(47<low&&low<58||64<low&&low<91||96<low&&low<123)&&start<end){
                low=s.charAt(++start);
            }
            while (!(47<high&&high<58||64<high&&high<91||96<high&&high<123)&&start<end){
                high=s.charAt(--end);
            }
            if (start>=end){
                break;
            }
            if (Character.toLowerCase(low)!=Character.toLowerCase(high)){
                return false;
            }
            start++;
            end--;

        }
        return true;
    }
}
