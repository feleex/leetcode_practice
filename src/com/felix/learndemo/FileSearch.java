package com.felix.learndemo;

/**
 * @author felix
 * @date 2021-04-20 10:17
 */
public class FileSearch implements Search {

    @Override
    public void searchdoc(String s) {
        System.out.println("文件搜索"+s);
    }
}
