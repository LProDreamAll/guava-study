package com.lhh.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import lombok.Getter;

/**
 * Copyright (C), 2019-2019
 * FileName: EventListener
 * Author:   s·D·bs
 * Date:     2019/5/31 14:41
 * Description: 消息监听类
 * Motto: 0.45%
 */
@Getter
public class EventListener {

    public int lastMessage = 0;

    @Subscribe
    public void listen(Event event) {
        lastMessage = event.getMessage();
        System.out.println("Message:" + lastMessage);
    }
}
