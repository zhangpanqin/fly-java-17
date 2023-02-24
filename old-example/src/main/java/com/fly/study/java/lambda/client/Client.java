package com.fly.study.java.lambda.client;

import com.fly.study.java.lambda.enitity.Gender;
import com.fly.study.java.lambda.enitity.UserBO;
import com.fly.study.java.lambda.enitity.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2019-09-25-20:46
 * @description 测试方法
 */
public class Client {

    private List<UserDTO> userDTOS;

    @BeforeEach
    public void before() {
        userDTOS = new ArrayList<>(16);
        userDTOS.add(UserDTO.builder().age(18).id(1).username("陈平安").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(19).id(2).username("宁姚").gender(Gender.FEMALE).build());
        userDTOS.add(UserDTO.builder().age(21).id(4).username("周米粒").gender(Gender.FEMALE).build());
        userDTOS.add(UserDTO.builder().age(23).id(6).username("李宝瓶").gender(Gender.FEMALE).build());
        userDTOS.add(UserDTO.builder().age(22).id(5).username("阮秀").gender(Gender.FEMALE).build());
        userDTOS.add(UserDTO.builder().age(20).id(3).username("崔东山").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(30).id(7).username("齐静春").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(32).id(9).username("阿良").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(31).id(8).username("陈清都").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(33).id(10).username("左右").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(41).id(12).username("崔诚").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(42).id(13).username("李希圣").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(34).id(11).username("裴钱").gender(Gender.FEMALE).build());
        userDTOS.add(UserDTO.builder().age(44).id(15).username("崔瀺").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(43).id(14).username("文圣老爷").gender(Gender.MALE).build());
    }
    @Test
    public void filter() {
        final UserDTO build = UserDTO.builder().age(0).build();
        final List<UserDTO> collect = userDTOS.stream().filter(userDTO ->
        {
            int a=build.getAge()+1;
                    build.setAge(a);
            return userDTO.getAge() < 30;})
                .filter(userDTO -> {
                    int a=build.getAge()+1;
                    build.setAge(a);
        return userDTO.getAge() > 21;}).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(build.getAge());

    }

    @Test
    public void filter2() {
        Predicate<UserDTO> predicate= userDTO -> userDTO.getAge() < 30;
        Predicate<UserDTO> and = predicate.and(userDTO -> userDTO.getAge() > 21);
        final List<UserDTO> collect = userDTOS.stream().filter(and).collect(Collectors.toList());
        System.out.println(collect);
    }


    @Test
    public void map() {
        final List<UserBO> collect = userDTOS.stream().filter(userDTO -> userDTO.getId() < 5).map(userDTO -> UserBO.builder().age(userDTO.getAge()).name(userDTO.getUsername()).build()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void mapToLong() {
        LongStream longStream = userDTOS.stream().filter(userDTO -> userDTO.getId() < 5).mapToLong(UserDTO::getId);
        System.out.println(longStream.boxed().collect(Collectors.toList()));
    }

    @Test
    public void peek() {
        System.out.println(Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList()));
    }

    @Test
    public void sorted() {
        final List<UserDTO> collect = userDTOS.stream().sorted(Comparator.comparing(UserDTO::getId).reversed()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void skip() {
        final List<UserDTO> collect = userDTOS.stream().skip(2L).sorted(Comparator.comparing(UserDTO::getId)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void limit() {
        final List<UserDTO> collect = userDTOS.stream().limit(2L).sorted(Comparator.comparing(UserDTO::getId)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void map2() {
        final Stream<String> stringStream = Stream.of("1-2-3-4", "5-6-7-8-9-10", "11-12-13-14", "15-16-17-18-19");
        final List<String[]> collect = stringStream.map(item -> item.split("-")).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void flatMap() {
        final Stream<String> stringStream = Stream.of("1-2-3-4", "5-6-7-8-9-10", "11-12-13-14", "15-16-17-18-19");
        final List<String> collect = stringStream.map(item -> item.split("-")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void distinct() {
        final Stream<String> a1 = Stream.of("a1", "a2", "a1", "a2", "a3", "a4");
        System.out.println(a1.distinct().collect(Collectors.toList()));
    }

    @Test
    public void count() {
        System.out.println(userDTOS.stream().limit(2L).count());
    }

    @Test
    public void anyMatch() {
        final boolean b = userDTOS.stream().anyMatch(userDTO -> userDTO.getId() > 1);
    }

    @Test
    public void noneMatch() {
        System.out.println(userDTOS.stream().noneMatch(userDTO -> userDTO.getId() < 1));
    }

    @Test
    public void allMatch() {
        userDTOS.add(null);
        System.out.println(userDTOS.stream().allMatch(userDTO -> userDTO.getId() >= 1));
    }

    @Test
    public void findFirst() {
        System.out.println(userDTOS.stream().findFirst().get());
    }

    @Test
    public void findAny() {
        System.out.println(userDTOS.stream().findAny().get());
    }

    @Test
    public void testException() {
        final Stream<String> a1 = Stream.of("a1", "a2", null, "c1", "c2", "d4");
        System.out.println(a1.map(String::length).collect(Collectors.toList()));
    }

    @Test
    public void run6() {
        final List<String> strings = Arrays.asList("1", "2", "3", "4");
        final Stream<String> stream = strings.stream();
    }

}
