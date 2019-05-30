package com.lhh.guava.businesses;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2019-2019
 * FileName: structure
 * Author:   s·D·bs
 * Date:     2019/5/30 16:30
 * Description:
 * Motto: 0.45%
 */
public class structure {

    /**
     * cacheLoader
     *
     * @throws Exception
     */
    @Test
    public void TestLoadingCache() throws Exception {
        LoadingCache<String, String> build = CacheBuilder
                .newBuilder()
                .build(
                        new CacheLoader<String, String>() {
                            @Override
                            public String load(String key) throws Exception {
                                return "hello " + key + "!";
                            }
                        }
                );
        System.out.println("jerry value:" + build.apply("jerry"));
        System.out.println("jerry value:" + build.get("jerry"));
        System.out.println("peida value:" + build.get("peida"));
        System.out.println("peida value:" + build.apply("peida"));
        System.out.println("lisa value:" + build.apply("lisa"));
        build.put("harry", "ssdded");
        System.out.println("harry value:" + build.get("harry"));
    }

    /**
     * Callable
     *
     * @throws Exception
     */
    @Test
    public void testCallableCache() throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", () -> "hello " + "jerry" + "!");
        System.out.println("jerry value : " + resultVal);
        resultVal = cache.get("peida", () -> "hello " + "peida" + "!");
        System.out.println("peida value : " + resultVal);
    }

    /**
     * 不需要延迟处理(泛型的方式封装)
     *
     * @return
     */
    public <K, V> LoadingCache<K, V> cached(CacheLoader<K, V> cacheLoader) {
        return CacheBuilder
                .newBuilder()
                .maximumSize(2)
                .weakKeys()
                .softValues()
                .refreshAfterWrite(120, TimeUnit.SECONDS)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener((RemovalListener<K, V>) rn -> System.out.println(rn.getKey() + "被移除"))
                .build(cacheLoader);
    }

    /**
     * 通过key获取value
     * 调用方式 commonCache.get(key) ; return String

     * @return
     * @throws Exception
     */

    public LoadingCache<String, String> commonCache() throws Exception {

        return cached(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "hello " + key + "!";
            }
        });
    }


    @Test
    public void testCache() throws Exception{
        LoadingCache<String , String> commonCache=commonCache();
        System.out.println("peida:"+commonCache.get("peida"));
        commonCache.apply("harry");
        System.out.println("harry:"+commonCache.get("harry"));
        commonCache.apply("lisa");
        System.out.println("lisa:"+commonCache.get("lisa"));
    }

    private static Cache<String, String> cacheFormCallable = null;


    /**
     * 对需要延迟处理的可以采用这个机制；(泛型的方式封装)
     * @param <K>
     * @param <V>
     * @return V
     * @throws Exception
     */
    public static <K,V> Cache<K , V> callableCached() throws Exception {
        return CacheBuilder
                .newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
    }


    private String getCallableCache(final String userName) {
        try {
            //Callable只有在缓存值不存在时，才会调用
            return cacheFormCallable.get(userName, () -> {
                System.out.println(userName+" from db");
                return "hello "+userName+"!";
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testCallableCache1() throws Exception{
        final String u1name = "peida";
        final String u2name = "jerry";
        final String u3name = "lisa";
        cacheFormCallable=callableCached();
        System.out.println("peida:"+getCallableCache(u1name));
        System.out.println("jerry:"+getCallableCache(u2name));
        System.out.println("lisa:"+getCallableCache(u3name));
        System.out.println("peida:"+getCallableCache(u1name));

    }

}
