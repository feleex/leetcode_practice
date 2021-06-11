package com.felix.leecode;

import java.util.*;

/**
 * @author felix
 * @date 2021-06-11 15:18
 */
public class Lee076 {
    public static void main(String[] args) {

        String s = "cabefgecdaecf", t = "cae";
        System.out.println(method4(s, t));

    }
    public static String minWindow(String s, String t) {
        char[] son=t.toCharArray();
        char[] father=s.toCharArray();
        Set<Character> sonset=new HashSet<>();
        for (char c : son) {
            sonset.add(c);
        }
        int start=0;
        int end=0;
        int minsum=Integer.MAX_VALUE;
        Set<Character> tmpset=new HashSet<>();
        for (int i = 0; i <father.length ; i++) {
            if (sonset.contains(father[i])){
//                记录第一次出现的位置
                tmpset.add(father[i]);

            }
        }
        return "";
    }
    public static String second(String s, String t) {
        char[] son=t.toCharArray();
        char[] father=s.toCharArray();
        int minsums=Integer.MAX_VALUE;
        int start=0;
        Set<Character> sonset=new HashSet<>();
        for (char c : son) {
            sonset.add(c);
        }
        List<Character> keychars=new ArrayList<>();
        List<Integer> indexints=new ArrayList<>();
        for (int i = 0; i <father.length ; i++) {
            if (sonset.contains(father[i])){
                keychars.add(father[i]);
                indexints.add(i);
            }
        }
        int size=keychars.size();
        start=indexints.get(0);
        List<Character> tmplist=new ArrayList<>();

        int index=0;
        tmplist.add(keychars.get(0));
        if (sonset.size()==1&&(sonset.contains(tmplist.get(0)))){
            return tmplist.get(0)+"";
        }
        for (int i = 1; i <size ; i++) {
            tmplist.add(keychars.get(i));
            if (!keychars.get(i).equals(tmplist.get(0))) {
                if (isvalid(tmplist, sonset)) {
                    if (minsums > (indexints.get(i) - indexints.get(start))) {
                        minsums = indexints.get(i) - indexints.get(start);
                        index = start;

                    }
                    tmplist.remove(0);
                    start++;
//                    tmplist = trimlist(tmplist, size - 1);
                    while (tmplist.subList(1,tmplist.size()).contains(tmplist.get(0))){
                        tmplist=tmplist.subList(1,tmplist.size());
                        start++;
                    }
//                    tmplist.remove(keychars.get(start));
//                    tmplist = trimlist(tmplist, size - 1);
                }
            }else {
                tmplist.remove(0);
                start++;
            }
        }
        if (minsums==Integer.MAX_VALUE){
            return "";
        }else {
            return s.substring(indexints.get(index),indexints.get(index)+minsums+1);
        }

    }

    private static List trimlist(List<Character> tmplist,int length) {
        int size=tmplist.size();
        Set<Character> tmpset=new HashSet<>();
        int index=0;
        for (int i = size-1; i >=0 ; i--) {
            tmpset.add(tmplist.get(i));
            if (tmpset.size()==length){
                index=i;
                break;
            }
        }
        return tmplist.subList(index,size);
    }

    public static boolean isvalid(List list,Set sonset){
        int size=list.size();
        for (int i = 0; i <size ; i++) {
            sonset.remove(list.get(i));
        }
        return sonset.size()==0?true:false;
    }
    public static  String method3(String s,String t){
        char[] son=t.toCharArray();
        char[] father=s.toCharArray();
        int minsums=Integer.MAX_VALUE;
        int start=0;
        Map<Character,Integer> sonmap=new HashMap<>();
        for (char c : son) {
            sonmap.put(c,sonmap.getOrDefault(c,0)+1);
        }
        List<Character> keychars=new ArrayList<>();
        List<Integer> indexints=new ArrayList<>();
        for (int i = 0; i <father.length ; i++) {
            if (sonmap.containsKey(father[i])){
                keychars.add(father[i]);
                indexints.add(i);
            }
        }
        int size=keychars.size();
        int index=0;
        List<Character> tmplist=new ArrayList<>();
        Map<Character,Integer> tmpmap=new HashMap<>();

        for (int i = 0; i <size ; i++) {
            char tmpkey=keychars.get(i);
            tmplist.add(tmpkey);
            tmpmap.put(tmpkey,tmpmap.getOrDefault(tmpkey,0)+1);
            if (realisvalid(tmplist,sonmap,t.length())){
                if (minsums>(indexints.get(i)-indexints.get(start))){
                    minsums=(indexints.get(i)-indexints.get(start));
                    index=start;

                }
//              匹配上了，删去数组头节点，然后重新进行下次匹配，找到下一个使长度最短的头节点
                tmpmap.put(tmplist.get(0),tmpmap.get(tmplist.get(0))-1);
                tmplist.remove(0);

                start++;
//              下一个首节点无关轻重时，可以删除
                while (tmplist.size()>0&&tmpmap.get(tmplist.get(0))>sonmap.get(tmplist.get(0))){
                    tmpmap.put(tmplist.get(0),tmpmap.get(tmplist.get(0))-1);
                    tmplist.remove(0);

                    start++;
                }
            }else {
                while (tmpmap.get(tmplist.get(0))>sonmap.get(tmplist.get(0))){
                    tmpmap.put(tmplist.get(0),tmpmap.get(tmplist.get(0))-1);
                    tmplist.remove(0);
                    start++;
                }
            }
        }
        if (minsums==Integer.MAX_VALUE){
            return  "";
        }else {
            return s.substring(indexints.get(index),indexints.get(index)+minsums+1);
        }

    }
    public static boolean realisvalid(List<Character> list,Map<Character,Integer> sonmap,int sonmapsum){
        if (list.size()<sonmapsum){
            return false;
        }
        Map<Character,Integer> tmpmap=new HashMap<>();
        tmpmap.putAll(sonmap);
        for (Character o : list) {
            tmpmap.put(o,tmpmap.get(o)-1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : tmpmap.entrySet()) {
            if (characterIntegerEntry.getValue()>0){
                return false;
            }
        }
        return true;
    }
    public static String method4(String s,String t){
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
