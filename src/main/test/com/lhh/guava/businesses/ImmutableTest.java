package com.lhh.guava.businesses;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (C), 2019-2019
 * FileName: ImmutableTest
 * Author:   s·D·bs
 * Date:     2019/5/30 17:37
 * Description:
 * Motto: 0.45%
 */
public class ImmutableTest {

    /**
     * 它用起来笨拙繁琐你不得不在每个防御性编程拷贝的地方用这个方法
     * 它不安全：如果有对象reference原始的被封装的集合类，这些方法返回的集合也就不是正真的不可改变。
     * 效率低：因为它返回的数据结构本质仍旧是原来的集合类，所以它的操作开销，包括并发下修改检查，
     * hash table里的额外数据空间都和原来的集合是一样的。
     */

    /**
     * 可变集合类型	可变集合源：JDK or Guava?	Guava不可变集合
     * Collection	JDK	ImmutableCollection
     * List	JDK	ImmutableList
     * Set	JDK	ImmutableSet
     * SortedSet/NavigableSet	JDK	ImmutableSortedSet
     * Map	JDK	ImmutableMap
     * SortedMap	JDK	ImmutableSortedMap
     * Multiset	Guava	ImmutableMultiset
     * SortedMultiset	Guava	ImmutableSortedMultiset
     * Multimap	Guava	ImmutableMultimap
     * ListMultimap	Guava	ImmutableListMultimap
     * SetMultimap	Guava	ImmutableSetMultimap
     * BiMap	Guava	ImmutableBiMap
     * ClassToInstanceMap	Guava	ImmutableClassToInstanceMap
     * Table	Guava	ImmutableTable
     */
    @Test
    public void testJDKImmutable() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list);

        List<String> unmodifiableList = Collections.unmodifiableList(list);

        System.out.println(unmodifiableList);

        List<String> unmodifiableList1 = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        System.out.println(unmodifiableList1);

        String temp = unmodifiableList.get(1);
        System.out.println("unmodifiableList [0]：" + temp);

        list.add("baby");
        System.out.println("list add a item after list:" + list);
        System.out.println("list add a item after unmodifiableList:" + unmodifiableList);

        /**
         * 下面两个会报错
         */
        unmodifiableList1.add("bb");
        System.out.println("unmodifiableList add a item after list:" + unmodifiableList1);

        unmodifiableList.add("cc");
        System.out.println("unmodifiableList add a item after list:" + unmodifiableList);
    }

    /**
     * 一个immutable集合可以有以下几种方式来创建：
     * <p>
     * 用copyOf方法, 譬如, ImmutableSet.copyOf(set)
     * 使用of方法，譬如，ImmutableSet.of(“a”, “b”, “c”)或者ImmutableMap.of(“a”, 1, “b”, 2)
     * 使用Builder类
     */
    @Test
    public void testGuavaImmutable() {

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list：" + list);

        ImmutableList<String> imlist = ImmutableList.copyOf(list);
        System.out.println("imlist：" + imlist);

        ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
        System.out.println("imOflist：" + imOflist);

        ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println("imSortList：" + imSortList);

        list.add("baby");
        System.out.println("list add a item after list:" + list);
        System.out.println("list add a item after imlist:" + imlist);

        ImmutableSet<Color> imColorSet =
                ImmutableSet.<Color>builder()
                        .add(new Color(0, 255, 255))
                        .add(new Color(0, 191, 255))
                        .build();

        System.out.println("imColorSet:" + imColorSet);
    }

    @Test
    public void testCotyOf() {
        ImmutableSet<String> imSet = ImmutableSet.of("peida", "jerry", "harry", "lisa");
        System.out.println("imSet：" + imSet);
        ImmutableList<String> imlist = ImmutableList.copyOf(imSet);
        System.out.println("imlist：" + imlist);
        ImmutableSortedSet<String> imSortSet = ImmutableSortedSet.copyOf(imSet);
        System.out.println("imSortSet：" + imSortSet);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "x");
        }
        System.out.println("list：" + list);
        ImmutableList<String> imInfolist = ImmutableList.copyOf(list.subList(2, 18));
        System.out.println("imInfolist：" + imInfolist);
        int imInfolistSize = imInfolist.size();
        System.out.println("imInfolistSize：" + imInfolistSize);
        ImmutableSet<String> imInfoSet = ImmutableSet.copyOf(imInfolist.subList(2, imInfolistSize - 3));
        System.out.println("imInfoSet：" + imInfoSet);
    }

    @Test
    public void testAsList() {
        ImmutableList<String> imList = ImmutableList.of("peida", "jerry", "harry", "lisa", "jerry");
        System.out.println("imList：" + imList);
        ImmutableSortedSet<String> imSortSet = ImmutableSortedSet.copyOf(imList);
        System.out.println("imSortSet：" + imSortSet);
        System.out.println("imSortList as list：" + imSortSet.asList());
    }

}
