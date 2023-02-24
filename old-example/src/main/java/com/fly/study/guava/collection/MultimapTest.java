package com.fly.study.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 张攀钦
 * @date 2019-12-05-10:54
 * @description
 */
public class MultimapTest {
    private static final Pattern TIME_SPLIT = Pattern.compile("#");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
    private Set<String> set = Sets.newHashSetWithExpectedSize(1000000);


    private int keyCount = 1000;

    private int valueCount = 1000;

    @BeforeEach
    public void before() throws InterruptedException {

        for (int i = 0; i < keyCount; i++) {
            for (int j = 0; j < valueCount; j++) {
                Thread.sleep(0,100);
                String s = LocalDateTime.now().format(dateTimeFormatter);
                String concat = String.valueOf(i).concat("#").concat(s);
                set.add(concat);
            }
        }
    }

    @Test
    public void run2() {
        long l = System.currentTimeMillis();
        ArrayListMultimap<String, String> multimap = ArrayListMultimap.create(100, 1000);
        set.stream().forEach(item -> {
            String[] split = TIME_SPLIT.split(item);
            multimap.put(split[0], split[1]);
        });
        ArrayListMultimap<String, String> multimap2 = ArrayListMultimap.create(100, 1000);
        for (String key : multimap.keySet()) {
            List<String> strings = multimap.get(key);
            List<String> collect = strings.stream().sorted().collect(Collectors.toList());
            if(collect.size()>1){
                multimap2.put(key,collect.get(0));
                multimap2.put(key,collect.get(collect.size()-1));
                continue;
            }
            multimap2.put(key,collect.get(0));
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void run3() {
        ArrayList<String> strings = Lists.newArrayList("1", "2", "5", "3");
//        strings.stream().collect()
    }
}
