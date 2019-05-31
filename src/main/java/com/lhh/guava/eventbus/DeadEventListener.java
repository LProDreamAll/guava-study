package com.lhh.guava.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * Copyright (C), 2019-2019
 * FileName: DeadEventListener
 * Author:   s·D·bs
 * Date:     2019/5/31 14:47
 * Description: EventBus发送的消息都不是订阅者关心的称之为Dead Event
 * Motto: 0.45%
 */
public class DeadEventListener {

    boolean notDelivered = false;

    @Subscribe
    public void listen(DeadEvent event) {
        notDelivered = true;
    }

    public boolean isNotDelivered() {
        return notDelivered;
    }
}
