package com.felix.learndemo;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author felix
 * @date 2021-04-20 10:16
 */
public class ServiceLoadDemo {
    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search =  iterator.next();
            search.searchdoc("hello world");
        }
    }
}
