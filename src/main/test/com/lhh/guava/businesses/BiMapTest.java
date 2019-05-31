package com.lhh.guava.businesses;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2019
 * FileName: BiMap
 * Author:   s·D·bs
 * Date:     2019/5/31 9:25
 * Description: 双向关联的map结构
 * Motto: 0.45%
 */
public class BiMapTest {


    /**
     * 根据key获取value
     * 根据value获取key ？ 逆转map
     */
    @Test
    public void logMapTest() {
        Map<Integer, String> logfileMap = Maps.newHashMap();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
    }

    /**
     * 逆转map
     * 装到新的map中
     * //todo 如何处理重复的value的情况。不考虑的话，反转的时候就会出现覆盖的情况.
     * 如果在反转的map中增加一个新的key，倒转前的map是否需要更新一个值呢?
     */
    public static <S, T> Map<T, S> getInverseMap(Map<S, T> map) {
        Map<T, S> inverseMap = new HashMap<T, S>();
        for (Map.Entry<S, T> entry : map.entrySet()) {
            inverseMap.put(entry.getValue(), entry.getKey());
        }
        return inverseMap;
    }

    /**
     * BiMap数据的强制唯一性
     */
    @Test
    public void test_BiMapTest() {
        HashBiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> fileLogMap = logfileMap.inverse();
        System.out.println("fileLogMap:" + fileLogMap);
    }

    /**
     * inverse方法会返回一个反转的BiMap，但是注意这个反转的map不是新的map对象，它实现了一种视图关联，
     * 这样你对于反转后的map的所有操作都会影响原先的map对象
     */
    @Test
    public void test_inverse_BiMapTest() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);
        logfileMap.put(4, "d.log");
        System.out.println("logfileMap:" + logfileMap);
        System.out.println("filelogMap:" + filelogMap);
    }


}
