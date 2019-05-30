package com.lhh.guava.businesses;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2019-2019
 * FileName: MultisetTest
 * Author:   s·D·bs
 * Date:     2019/5/30 17:45
 * Description: Multiset不是Map
 * Motto: 0.45%
 */
public class MultisetTest {

    /**
     * Multiset占据了List和Set之间的一个灰色地带：允许重复，但是不保证顺序。
     */
    //跟踪每种对象的数量
    String strWorld = "wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
            "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
            "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";

    @Test
    public void test_Jdk_WordCount() {
        String[] words = strWorld.split("\\|");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) {
                countMap.put(word, 1);
            } else {
                countMap.put(word, count + 1);
            }
        }
        System.out.println("countMap：");
        for (String key : countMap.keySet()) {
            System.out.println(key + " count：" + countMap.get(key));
        }
    }

    @Test
    public void test_MultSetWordCount() {
        List<String> wordList = new ArrayList<>(Arrays.asList(strWorld.split("\\|")));
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }
    }

    @Test
    public void testMultsetWordCount() {
        String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
        String[] words = strWorld.split("\\|");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);


        //System.out.println("wordsMultiset："+wordsMultiset);

        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }

        if (!wordsMultiset.contains("peida")) {
            wordsMultiset.add("peida", 2);
        }
        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }


        if (wordsMultiset.contains("peida")) {
            wordsMultiset.setCount("peida", 23);
        }

        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }

        if (wordsMultiset.contains("peida")) {
            wordsMultiset.setCount("peida", 23, 45);
        }

        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }

        if (wordsMultiset.contains("peida")) {
            wordsMultiset.setCount("peida", 44, 67);
        }

        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }
    }

    /**
     * Multiset中的元素的重复个数只会是正数，且最大不会超过Integer.MAX_VALUE。
     * 设定计数为0的元素将不会出现multiset中，也不会出现elementSet()和entrySet()的返回结果中。
     *
     * multiset.size() 方法返回的是所有的元素的总和，相当于是将所有重复的个数相加。如果需要知道每个元素的个数可以使用
     * elementSet().size()得到.(因而调用add(E)方法会是multiset.size()增加1).
     * multiset.iterator() 会循环迭代每一个出现的元素，迭代的次数与multiset.size()相同。
     * iterates over each occurrence of each element, so the length of the iteration is equal to multiset.size().
     * Multiset 支持添加、移除多个元素以及重新设定元素的个数。执行setCount(element,0)相当于移除multiset中所有的相同元素。
     * 调用multiset.count(elem)方法时，如果该元素不在该集中，那么返回的结果只会是0。
     */
}
