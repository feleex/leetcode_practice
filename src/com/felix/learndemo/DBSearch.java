package com.felix.learndemo;

/**
 * @author felix
 * @date 2021-04-20 10:18
 */
public class DBSearch implements Search {

    @Override
    public void searchdoc(String s) {
        System.out.println("数据库搜索"+s);
    }
}