package com.lhh.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Copyright (C), 2019-2019
 * FileName: IntegerListener
 * Author:   s·D·bs
 * Date:     2019/5/31 14:57
 * Description:
 * Motto: 0.45%
 */
public class IntegerListener {
    private Integer lastMessage;

    @Subscribe
    public void listen(Integer integer) {
        lastMessage = integer;
        System.out.println("Message:"+lastMessage);
    }

    public Integer getLastMessage() {
        return lastMessage;
    }
}
