package com.lhh.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Copyright (C), 2019-2019
 * FileName: NumberListener
 * Author:   s·D·bs
 * Date:     2019/5/31 14:52
 * Description: 　　如果Listener A监听Event A, 而Event A有一个子类Event B, 此时Listener A将同时接收Event A和B消息，
 *
 * Motto: 0.45%
 */
public class NumberListener {

    private Number lastMessage;

    @Subscribe
    public void listen(Number integer) {
        lastMessage = integer;
        System.out.println("Message:"+lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
