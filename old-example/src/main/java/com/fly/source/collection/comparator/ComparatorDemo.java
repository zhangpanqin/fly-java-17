package com.fly.source.collection.comparator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 张攀钦
 * @date 2020-08-14-13:46
 */
public class ComparatorDemo {


    private List<User> userList;

    @BeforeEach
    public void before() {
        userList = new ArrayList<>();
        userList.add(new User("a", 2));
        userList.add(new User("a", 1));
        userList.add(new User("b", 1));
        userList.add(new User("b", 3));
        userList.add(new User("c", 1));
        userList.add(new User("d", 1));
        userList.add(new User("d", 2));
    }

    @Test
    public void run1() {
        final Comparator<User> userComparator = Comparator.comparing(User::getName).thenComparingInt(User::getAge).reversed();
        userList.sort(userComparator);
        System.out.println(userList);
        final List<User> collect = userList.stream().sorted(userComparator).collect(Collectors.toList());
        System.out.println(collect==userList);
        System.out.println(collect);
    }
}
