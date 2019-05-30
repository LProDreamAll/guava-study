package com.lhh.guava.businesses;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Copyright (C), 2019-2019
 * FileName: ThrowAblesTest
 * Author:   s·D·bs
 * Date:     2019/5/30 17:30
 * Description: ThrowAblesTest
 * Motto: 0.45%
 */
public class ThrowAblesTest {

    @Test
    public void test_ThrowAblesTest() {
        try {
            throw new Exception();
        } catch (Throwable t) {
            String ss = Throwables.getStackTraceAsString(t);
            System.out.println("ss:" + ss);
            Throwables.propagate(t);
        }
    }

    @Test
    public void test_call() throws IOException {
        try {
            throw new IOException();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
            throw Throwables.propagate(t);
        }
    }

    /**
     * 将检查异常转换成未检查异常,例如：
     */
    @Test
    public void testCheckException() {
        try {
            URL url = new URL("http://ociweb.com");
            final InputStream in = url.openStream();
            // read from the input stream
            in.close();
        } catch (Throwable t) {
            throw Throwables.propagate(t);
        }
    }
}
