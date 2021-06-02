package com.felix.leecode;

import java.util.Stack;

/**
 * @author felix
 * @date 2021-06-02 15:58
 */
public class Lee071 {
    public static void main(String[] args) {
    String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }
    public static  String simplifyPath(String path) {
        Stack<String> stringStack=new Stack<>();
        String[] stringarray=path.split("/");
        String sb="";
        for (int i = 1; i <stringarray.length ; i++) {
            switch (stringarray[i]){
                case ".":
                case "":
                    continue;
                case "..":
                    if (stringStack.isEmpty()){
                        continue;
                    }
                    stringStack.pop();
                    continue;
                default:
                    stringStack.push(stringarray[i]);
            }
        }
        while (!stringStack.isEmpty()){
            sb="/"+stringStack.pop()+sb;
        }
        if ("".equals(sb)){
            sb="/";
        }
        return sb;
    }
}
