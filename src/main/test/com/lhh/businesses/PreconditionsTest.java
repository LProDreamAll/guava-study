package com.lhh.businesses;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * Copyright (C), 2019-2019
 * FileName: PreconditionsTest
 * Author:   s·D·bs
 * Date:     2019/5/30 11:03
 * Description: 业务测试
 * Motto: 0.45%
 */
public class PreconditionsTest {

    /**
     * 1 .checkArgument(boolean) ：
     * 　　功能描述：检查boolean是否为真。 用作方法中检查参数
     * 　　失败时抛出的异常类型: IllegalArgumentException
     * <p>
     * 　　2.checkNotNull(T)：
     * 　　功能描述：检查value不为null， 直接返回value；
     * 　　失败时抛出的异常类型：NullPointerException
     * <p>
     * 　　3.checkState(boolean)：
     * 　　功能描述：检查对象的一些状态，不依赖方法参数。 例如， Iterator可以用来next是否在remove之前被调用。
     * 　　失败时抛出的异常类型：IllegalStateException
     * <p>
     * 　　4.checkElementIndex(int index, int size)：
     * 　　功能描述：检查index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0, size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。
     * 　　失败时抛出的异常类型：IndexOutOfBoundsException
     * <p>
     * 　　5.checkPositionIndex(int index, int size)：
     * 　　功能描述：检查位置index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0， size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。
     * 　　失败时抛出的异常类型：IndexOutOfBoundsException
     * <p>
     * 　　6.checkPositionIndexes(int start, int end, int size)：
     * 　　功能描述：检查[start, end)是一个长度为size的list， string或array合法的范围子集。伴随着错误信息。
     * 　　失败时抛出的异常类型：IndexOutOfBoundsException
     */
    @Test
    public void Preconditions() throws Exception {

        getPerson(8, "peida");

        getPerson(-9, "peida");

        getPerson(8, "");

        getPerson(8, null);

        getPersonByPrecondition(8, "peida");

        try {
            getPersonByPrecondition(-9, "peida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return void
     * @Author s·D·bs
     * @Description 模拟的线上的接口
     * fuck 烦
     * @Date 11:04 2019/5/30
     * @Param [age, name]
     */
    public static void getPerson(int age, String name) throws Exception {

        if (age > 0 && name != null && !name.equals("")) {
            System.out.println("a person age:" + age + ",neme:" + name);
        } else {
            System.out.println("参数输入有误！");
        }
    }

    /**
     * @return void
     * @Author s·D·bs
     * @Description //Guava的优雅处理方式
     * @Date 11:09 2019/5/30
     * @Param [age, name]
     */
    public static void getPersonByPrecondition(int age, String name) throws Exception {

        Preconditions.checkNotNull(name, "name为null");
        Preconditions.checkArgument(name.length() > 0, "name为\'\'");
        Preconditions.checkArgument(age > 0, "age 必须大于0");
        System.out.println("a person age:" + age + ",name:" + name);
    }

}
