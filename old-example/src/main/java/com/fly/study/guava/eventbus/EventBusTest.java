package com.fly.study.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EventObject;

/**
 * @author 张攀钦
 * @date 2019-12-06-00:04
 * @description
 */
public class EventBusTest {

    private static EventBus eventBus = new EventBus();

    @BeforeEach
    public void before() {
        eventBus.register(new EventBusChangeRecorder());
    }

    @Test
    public void run1() {

        eventBus.post(new My1Event("我是 1"));
    }

    @Test
    public void run2() {
        eventBus.post(new My2Event("我是 2"));
    }


}


class My1Event extends EventObject {
    private String name;

    public My1Event(String name) {
        super(name);
        this.name = name;
    }
}

class My2Event extends EventObject {
    private String name;

    public My2Event(String name) {
        super(name);
        this.name = name;
    }
}

class EventBusChangeRecorder {
    @Subscribe
    public void recordCustomerChange1(My1Event e) {
        System.out.println("1" + e.getSource().toString());
    }

    @Subscribe
    public void recordCustomerChange(My2Event e) {
        System.out.println("2" + e.getSource().toString());
    }
}