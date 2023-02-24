package com.fly.study.guava.string;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-05-23:17
 * @description
 */
public class JoinerTest {

    @Test
    public void run1() {
        final Joiner on = Joiner.on("-").skipNulls();
        final String join = on.join("1","2");
        System.out.println(on.join("4", "5"));
        System.out.println(join);
    }

}
