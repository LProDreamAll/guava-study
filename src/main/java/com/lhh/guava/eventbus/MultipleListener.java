package com.lhh.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import lombok.Getter;

/**
 * Copyright (C), 2019-2019
 * FileName: MultipleListener
 * Author:   s·D·bs
 * Date:     2019/5/31 14:43
 * Description: 多个消息的订阅
 * Motto: 0.45%
 */
@Getter
public class MultipleListener {

    public Integer lastInteger;
    public Long lastLong;

    @Subscribe
    public void listenInteger(Integer event) {
        lastInteger = event;
        System.out.println("event Integer:"+lastInteger);
    }

    @Subscribe
    public void listenLong(Long event) {
        lastLong = event;
        System.out.println("event Long:"+lastLong);
    }

}
