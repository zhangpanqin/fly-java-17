package com.fly.study.java.object;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张攀钦
 * @date 2019-12-15-12:29
 * @description 验证 final 域禁止重排序
 */
@Data
@Slf4j
public class FinalParam {
//    private final String string;

    int a;

    public FinalParam() {
//        this.string = "张攀钦";
        this.a = 100;
    }

    static FinalParam obj;

    public static void writeObj() {
        obj = new FinalParam();
    }

    public static void readObj() {
        FinalParam finalParam =obj;
        System.out.println(finalParam.a);
    }

    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            writeObj();
        };
        Runnable runnable2 = () -> {
            readObj();
        };

        final ExecutorService executorService = Executors.newFixedThreadPool(1000);

        executorService.execute(()->{
            while (true) {
                executorService.execute(runnable1);
            }
        });

        executorService.execute(()->{
            while (true){
                executorService.execute(runnable2);
            }
        });
    }
}
