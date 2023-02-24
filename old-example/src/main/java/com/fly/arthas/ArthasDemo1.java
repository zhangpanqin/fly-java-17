package com.fly.arthas;

/**
 * Arthas 研究，cpu 100%
 *
 * @author Administrator
 */
public class ArthasDemo1 {
    public static void main(String[] args) throws InterruptedException {
        int count = 1;
        while (true) {
            Thread.sleep(1000);
            sum(count);
            count++;
        }
    }

    public static int sum(int count) {
        return count + 2;
    }
}
