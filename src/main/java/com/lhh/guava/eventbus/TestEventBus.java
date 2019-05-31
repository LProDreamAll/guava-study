package com.lhh.guava.eventbus;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * Copyright (C), 2019-2019
 * FileName: TestEventBus
 * Author:   s·D·bs
 * Date:     2019/5/31 14:42
 * Description:
 * Motto: 0.45%
 */
public class TestEventBus {

    @Test
    public void testReceiveEvent() throws Exception {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new Event(200));
        eventBus.post(new Event(300));
        eventBus.post(new Event(400));

        System.out.println("LastMessage:" + listener.getLastMessage());

    }


    /**
     * 测试多个消息
     *
     */
    @Test
    public void testMultipleEvents() throws Exception {

        EventBus eventBus = new EventBus("test");
        MultipleListener multiListener = new MultipleListener();

        eventBus.register(multiListener);

        eventBus.post(new Integer(100));
        eventBus.post(new Integer(200));
        eventBus.post(new Integer(300));
        eventBus.post(new Long(800));
        eventBus.post(new Long(800990));
        eventBus.post(new Long(800882934));

        System.out.println("LastInteger:" + multiListener.getLastInteger());
        System.out.println("LastLong:" + multiListener.getLastLong());
    }

    @Test
    public void testDeadEventListeners() throws Exception {

        EventBus eventBus = new EventBus("test");
        DeadEventListener deadEventListener = new DeadEventListener();
        eventBus.register(deadEventListener);

        eventBus.post(new Event(200));
        eventBus.post(new Event(300));

        System.out.println("deadEvent:"+deadEventListener.isNotDelivered());

    }


    @Test
    public void testEventsFromSubclass() throws Exception {

        EventBus eventBus = new EventBus("test");
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener();
        eventBus.register(integerListener);
        eventBus.register(numberListener);

        eventBus.post(new Integer(100));

        System.out.println("integerListener message:"+integerListener.getLastMessage());
        System.out.println("numberListener message:"+numberListener.getLastMessage());

        eventBus.post(new Long(200L));

        System.out.println("integerListener message:"+integerListener.getLastMessage());
        System.out.println("numberListener message:"+numberListener.getLastMessage());
    }
}
