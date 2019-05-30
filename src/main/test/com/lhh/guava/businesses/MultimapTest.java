package com.lhh.guava.businesses;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2019-2019
 * FileName: MultimapTest
 * Author:   s·D·bs
 * Date:     2019/5/30 18:05
 * Description:
 * Motto: 0.45%
 */
public class MultimapTest {

    Map<String, List<StudentScore>> StudentScoreMap = new HashMap<>();


    @Test
    public void test_JdkStudentScore() {

        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            addStudentScore("peida", studentScore);
        }

        System.out.println("StudentScoreMap:" + StudentScoreMap);
        System.out.println("StudentScoreMap:" + StudentScoreMap.size());
        System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("peida"));

        System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("jerry"));
        System.out.println("StudentScoreMap:" + StudentScoreMap.size());
        System.out.println("StudentScoreMap:" + StudentScoreMap.get("peida").size());

        List<StudentScore> StudentScoreList = StudentScoreMap.get("peida");
        if (StudentScoreList != null && StudentScoreList.size() > 0) {
            for (StudentScore stuScore : StudentScoreList) {
                System.out.println("stuScore one:" + stuScore.CourseId + " score:" + stuScore.score);
            }
        }
    }

    public void addStudentScore(final String stuName, final StudentScore studentScore) {
        List<StudentScore> stuScore = StudentScoreMap.get(stuName);
        if (stuScore == null) {
            stuScore = new ArrayList<StudentScore>();
            StudentScoreMap.put(stuName, stuScore);
        }
        stuScore.add(studentScore);
    }


    @Test
    public void tests_tuScoreMultimap() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("peida", studentScore);
        }
        System.out.println("scoreMultimap:" + scoreMultimap);
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());
    }

    @Test
    public void teststuScoreMultimap() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("peida", studentScore);
        }
        System.out.println("scoreMultimap:" + scoreMultimap);
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        studentScore.clear();
        StudentScore studentScoreNew = new StudentScore();
        studentScoreNew.CourseId = 1034;
        studentScoreNew.score = 67;
        studentScore.add(studentScoreNew);
        System.out.println("scoreMultimap:" + scoreMultimap);
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());
    }


    /**
     * Multimap也支持一系列强大的视图功能：
     * <p>
     * asMap把自身Multimap<K, V>映射成Map<K, Collection>视图。这个Map视图支持remove和修改操作，但是不支持put和putAll。严格地来讲，当你希望传入参数是不存在的key，而且你希望返回的是null而不是一个空的可修改的集合的时候就可以调用asMap().get(key)。（你可以强制转型asMap().get(key)的结果类型－对SetMultimap的结果转成Set，对ListMultimap的结果转成List型－但是直接把ListMultimap转成Map<K, List>是不行的。）
     * entries视图是把Multimap里所有的键值对以Collection<Map.Entry<K, V>>的形式展现。
     * keySet视图是把Multimap的键集合作为视图
     * keys视图返回的是个Multiset，这个Multiset是以不重复的键对应的个数作为视图。这个Multiset可以通过支持移除操作而不是添加操作来修改Multimap。
     * values()视图能把Multimap里的所有值“平展”成一个Collection。这个操作和Iterables.concat(multimap.asMap().values())很相似，只是它返回的是一个完整的Collection。
     * 尽管Multimap的实现用到了Map，但Multimap<K, V>不是Map<K, Collection>。因为两者有明显区别：
     * <p>
     * Multimap.get(key)一定返回一个非null的集合。但这不表示Multimap使用了内存来关联这些键，相反，返回的集合只是个允许添加元素的视图。
     * 如果你喜欢像Map那样当不存在键的时候要返回null，而不是Multimap那样返回空集合的话，可以用asMap()返回的视图来得到Map<K, Collection>。（这种情况下，你得把返回的Collection强转型为List或Set）。
     * Multimap.containsKey(key)只有在这个键存在的时候才返回true。
     * Multimap.entries()返回的是Multimap所有的键值对。但是如果需要key-collection的键值对，那就得用asMap().entries()。
     * Multimap.size()返回的是entries的数量，而不是不重复键的数量。如果要得到不重复键的数目就得用Multimap.keySet().size()。
     */

    @Test
    public void test_stuScoreMultimap() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("peida", studentScore);
        }
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        StudentScore studentScore1 = new StudentScore();
        studentScore1.CourseId = 1034;
        studentScore1.score = 67;
        studentScore.add(studentScore1);

        StudentScore studentScore2 = new StudentScore();
        studentScore2.CourseId = 1045;
        studentScore2.score = 56;
        scoreMultimap.put("jerry", studentScore2);

        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());


        for (StudentScore stuScore : scoreMultimap.values()) {
            System.out.println("stuScore one:" + stuScore.CourseId + " score:" + stuScore.score);
        }

        scoreMultimap.remove("jerry", studentScore2);
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.get("jerry"));

        scoreMultimap.put("harry", studentScore2);
        scoreMultimap.removeAll("harry");
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.get("harry"));
    }
}

@ToString
class StudentScore {

    int CourseId;
    int score;
}
