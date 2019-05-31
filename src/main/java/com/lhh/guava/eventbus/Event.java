package com.lhh.guava.eventbus;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Copyright (C), 2019-2019
 * FileName: Event
 * Author:   s·D·bs
 * Date:     2019/5/31 14:39
 * Description: 消息实现类
 * Motto: 0.45%
 */

@Getter
public class Event {

    private final int message;

    public Event(int message) {
        this.message = message;
        System.out.println("event message:" + message);

    }
}
