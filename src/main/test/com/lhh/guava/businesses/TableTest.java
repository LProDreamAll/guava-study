package com.lhh.guava.businesses;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeSet;
import org.junit.Test;

/**
 * Copyright (C), 2019-2019
 * FileName: TableTest
 * Author:   s·D·bs
 * Date:     2019/5/31 9:38
 * Description: Table测试
 * Motto: 0.45%
 */
public class TableTest {


    /**
     * Table视图：
     * Map<FirstName, Map<LastName, Person>>
     * rowMap()返回一个Map<R, Map<C, V>>的视图。rowKeySet()类似地返回一个Set。
     * row(r)返回一个非null的Map<C, V>。修改这个视图Map也会导致原表格的修改。
     * 和列相关的方法有columnMap(), columnKeySet()和column(c)。（基于列的操作会比基于行的操作效率差些）
     * cellSet()返回的是以Table.Cell<R, C, V>为元素的Set。这里的Cell就类似Map.Entry，但是它是通过行和列来区分的。
     * Table有以下实现：
     * HashBasedTable：基于HashMap<R, HashMap<C, V>>的实现。
     * TreeBasedTable：基于TreeMap<R, TreeMap<C, V>>的实现。
     * ImmutableTable：基于ImmutableMap<R, ImmutableMap<C, V>>的实现。（注意，ImmutableTable已对稀疏和密集集合做了优化）
     * ArrayTable：ArrayTable是一个需要在构建的时候就需要定下行列的表格。这种表格由二维数组实现，这样可以在密集数据的表格的场合，
     * 提高时间和空间的效率。
     * Map<R, Map<C, V>>
     */
    @Test
    public void Table_Test() {
        Table<String, Integer, String> aTable = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        System.out.println(aTable);
        System.out.println(aTable.column(2));
        System.out.println(aTable.row("B"));
        System.out.println(aTable.get("B", 2));

        System.out.println(aTable.contains("D", 1));
        System.out.println(aTable.containsColumn(3));
        System.out.println(aTable.containsRow("C"));
        System.out.println(aTable.columnMap());
        System.out.println(aTable.rowMap());

        System.out.println(aTable.remove("B", 3));
    }

    /**
     * 有的时候，你的map的key并不是一种类型，他们是很多类型，你想通过映射他们得到这种类型，
     * guava提供了ClassToInstanceMap满足了这个目的。
     */
    @Test
    public void ClassToInstanceMapTest() {

        ClassToInstanceMap<String> classToInstanceMapString = MutableClassToInstanceMap.create();
        ClassToInstanceMap<Person> classToInstanceMap = MutableClassToInstanceMap.create();

        Person person = Person.of("peida", 20);
        System.out.println("person name :" + person.name + " age:" + person.age);
        classToInstanceMapString.put(String.class, "peida");
        System.out.println("string:" + classToInstanceMapString.getInstance(String.class));

        classToInstanceMap.putInstance(Person.class, person);
        Person person1 = classToInstanceMap.getInstance(Person.class);
        System.out.println("person1 name :" + person1.name + " age:" + person1.age);
    }

    /**
     * RangeSet用来处理一系列不连续，非空的range。
     * 当添加一个range到一个RangeSet之后，任何有连续的range将被自动合并，而空的range将被自动去除。例如：
     */
    @Test
    public void RangeSetTest(){
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.closedOpen(11, 15));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.open(15, 20));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.openClosed(0, 0));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.remove(Range.open(5, 10));
        System.out.println("rangeSet:"+rangeSet);
    }
}
