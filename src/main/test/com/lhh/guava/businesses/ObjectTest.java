package com.lhh.guava.businesses;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import java.util.Comparator;

/**
 * Copyright (C), 2019-2019
 * FileName: ObjectTest
 * Author:   s·D·bs
 * Date:     2019/5/30 13:25
 * Description: 复写的Object的方法测试
 * Motto: 0.45%
 */
public class ObjectTest {

    @Test
    public void equalTest() {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
        System.out.println(Objects.equal(Person.of("peida", 23), Person.of("peida", 23)));
        Person person = Person.of("peida", 23);
        System.out.println(Objects.equal(person, person));
    }

    @Test
    public void hashcodeTest() {
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a", "b"));
        System.out.println(Objects.hashCode("b", "a"));
        System.out.println(Objects.hashCode("a", "b", "c"));

        Person person = Person.of("peida", 23);
        System.out.println(Objects.hashCode(person));
        System.out.println(Objects.hashCode(person));
    }

    /**
     * @return void
     * @Author s·D·bs
     * @Description 一般的java写法
     * @Date 13:40 2019/5/30
     * @Param []
     */
    @Test
    public void compareTest() {

        Person person = Person.of("peida", 23);
        Person person1 = Person.of("aida", 25);
        Person person2 = Person.of("aida", 25);
        Person person3 = Person.of("aida", 26);
        Person person4 = Person.of("peida", 26);

        System.out.println(person.compareTo(person1));
        System.out.println(person1.compareTo(person2));
        System.out.println(person1.compareTo(person3));
        System.out.println(person.compareTo(person4));
        System.out.println(person4.compareTo(person));
    }


    @Test
    public void StudentTest() {

        Student student = Student.of("peida", 23, 80);
        Student student1 = Student.of("aida", 23, 36);
        Student student2 = Student.of("jerry", 24, 90);
        Student student3 = Student.of("peida", 23, 80);

        StudentComparator studentComparator = new StudentComparator();
        int compare = studentComparator.compare(student1, student2);
        System.out.println("compare = " + compare);

        System.out.println("==========equals===========");
        System.out.println(student.equals(student2));
        System.out.println(student.equals(student1));
        System.out.println(student.equals(student3));

        System.out.println("==========hashCode===========");
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
        System.out.println(student3.hashCode());
        System.out.println(student2.hashCode());

        System.out.println("==========toString===========");
        System.out.println(student.toString());
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        System.out.println("==========compareTo===========");
        System.out.println(student.compareTo(student1));
        System.out.println(student.compareTo(student2));
        System.out.println(student2.compareTo(student1));
        System.out.println(student2.compareTo(student));

    }
}

@RequiredArgsConstructor(staticName = "of")
class Person implements Comparable<Person> {

    @NonNull
    public String name;
    @NonNull
    public int age;

    @Override
    public int compareTo(Person o) {
        int cmpName = name.compareTo(o.name);
        if (cmpName != 0)
            return cmpName;
        if (age > o.age) {
            return 1;
        } else if (age < o.age) {
            return -1;
        }
        return 0;
    }
}

/**
 * Comparator 不如guava的 ComparisonChain
 * guava的自带的Ints.compare()
 */
class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.name.compareTo(p2.name);
        if (result != 0)
            return result;
        return Ints.compare(p1.age, p2.age);
    }
}

@RequiredArgsConstructor(staticName = "of")
class Student implements Comparable<Student> {

    @NonNull
    public String name;
    @NonNull
    public int age;
    @NonNull
    public int score;

    @Override
    public int compareTo(Student other) {
        return ComparisonChain.start()
                .compare(name, other.name)
                .compare(age, other.age)
                .compare(score, other.score, Ordering.natural().nullsLast())//null放到最后面
                .result();
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return ComparisonChain.start()
                .compare(s1.name, s2.name)
                .compare(s1.age, s2.age)
                .compare(s1.score, s2.score)
                .result();
    }
}
