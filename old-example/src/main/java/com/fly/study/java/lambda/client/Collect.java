package com.fly.study.java.lambda.client;

import com.fly.study.java.lambda.enitity.Gender;
import com.fly.study.java.lambda.enitity.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2019-09-28-14:36
 * @description Collect 测试
 */
public class Collect {

    private List<UserDTO> userDTOS;

    @BeforeEach
    public void before() {
        userDTOS = new ArrayList<>(32);
        userDTOS.add(UserDTO.builder().age(18).id(1).username("陈平安").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(18).id(333).username("陈平安33").gender(Gender.MALE).build());
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
    public void toMapTest() {
        Map<Integer, List<String>> collect = userDTOS.stream().collect(Collectors.toMap(UserDTO::getAge, item -> {
            List<String> objects = new ArrayList<>();
            objects.add(item.getUsername());
            return objects;
        },(left,r)->{
            left.addAll(r);
            return left;
        }));
        System.out.println(collect);
    }


    @Test
    public void collect1() {
        Map<Integer, UserDTO> map = new HashMap<>();
        final Map<Integer, UserDTO> collect = userDTOS.stream().collect(() -> {
                    System.out.println(map.hashCode());
                    return map;
                },
                (t1, t2) -> {
                    System.out.println(t1 == map);
                    t1.put(t2.getId(), t2);
                }
//                t1 是叠加的结果
                , (t1, t2) -> {
                    t1.putAll(t2);
                    t1.put(100, null);
                });
        System.out.println(collect.containsKey(100));
    }

    @Test
    public void averagingDouble() {
        System.out.println(userDTOS.stream().collect(Collectors.averagingDouble(UserDTO::getId)));
    }

    @Test
    public void averagingInt() {
        System.out.println(userDTOS.stream().collect(Collectors.averagingInt(UserDTO::getId)));
    }

    @Test
    public void averagingLong() {
        System.out.println(userDTOS.stream().collect(Collectors.averagingLong(UserDTO::getId)));
    }

    @Test
    public void max() {
        System.out.println(userDTOS.stream().max(Comparator.comparingInt(UserDTO::getId)));
        System.out.println(userDTOS.stream().collect(Collectors.maxBy(Comparator.comparingInt(UserDTO::getId))));
        System.out.println(userDTOS.stream().collect(Collectors.maxBy(Comparator.comparing(UserDTO::getId))));
        System.out.println(userDTOS.stream().collect(Collectors.maxBy((t1, t2) -> t1.getId() - t2.getId())));
    }

    @Test
    public void collectingAndThen() {
        String collect = userDTOS.stream().collect(
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(UserDTO::getId)), t2 -> {
                    return t2.get().getId() + "-最大 id";
                }));
        System.out.println(collect);

    }

    @Test
    public void counting() {
        Long collect = userDTOS.stream().collect(Collectors.counting());
        System.out.println(collect);
        System.out.println(userDTOS.stream().count());
    }

    @Test
    public void groupingBy1() {
        Map<Gender, List<UserDTO>> collect = userDTOS.stream().collect(Collectors.groupingBy(t1 -> t1.getGender()));
    }

    @Test
    public void groupingBy2() {
        final Map<Gender, Map<Integer, List<UserDTO>>> collect = userDTOS.parallelStream()
                .collect(Collectors.groupingBy(t1 -> t1.getGender(), Collectors.groupingBy(t2 -> t2.getAge())));
        System.out.println(collect);
    }

    @Test
    public void groupingBy3() {
        final Map<Gender, Optional<Integer>> collect = userDTOS.stream()
                .collect(Collectors.groupingBy(UserDTO::getGender,
                        Collectors.mapping(UserDTO::getAge, Collectors.maxBy(Comparator.comparingInt(t1->t1.intValue())))));
        System.out.println(collect);
    }

    @Test
    public void groupingBy4() {
        final Map<Gender, Optional<UserDTO>> collect = userDTOS.stream()
                .collect(Collectors.groupingBy(UserDTO::getGender,
                        Collectors.mapping(Function.identity(), Collectors.maxBy(Comparator.comparingInt(UserDTO::getAge)))));
        System.out.println(collect);
    }

    @Test
    public void joining1() {
        final Stream<String> a1 = Stream.of("a1", "a2", "a3", "a4", "a5");
        final String collect = a1.collect(Collectors.joining());
        System.out.println(collect);
    }

    @Test
    public void joining2() {
        final Stream<String> a1 = Stream.of("a1", "a2", "a3", "a4", "a5");
        final String collect = a1.collect(Collectors.joining("-"));
        System.out.println(collect);
    }


    @Test
    public void joining3() {
        final Stream<String> a1 = Stream.of("a1", "a2", "a3", "a4", "a5");
        final String collect = a1.collect(Collectors.joining("-", "前缀", "后缀"));
        System.out.println(collect);
    }

    @Test
    public void run4() {
        final String collect = userDTOS.stream().collect(Collectors.mapping(UserDTO::getUsername, Collectors.joining("-")));
        System.out.println(collect);
    }

    @Test
    public void joining4() {
        final Stream<String> a1 = Stream.of("a1", "a2", "a3", "a4", "a5");
        final String collect = a1.collect(Collectors.joining("-"));
        System.out.println(collect);
    }

    @Test
    public void maxBy() {
        final Optional<UserDTO> collect = userDTOS.stream().collect(Collectors.maxBy(Comparator.comparing(UserDTO::getAge)));
        System.out.println(collect.get());
    }

    @Test
    public void minBy() {
        final Optional<UserDTO> collect = userDTOS.stream().collect(Collectors.minBy(Comparator.comparing(UserDTO::getAge)));
        System.out.println(collect.get());
    }

    /**
     * 类似分组
     */
    @Test
    public void partitioningBy() {
        final Map<Boolean, List<UserDTO>> collect = userDTOS.stream().collect(Collectors.partitioningBy(userDTO -> userDTO.getGender().equals(Gender.MALE)));
    }

    /**
     *
     */
    @Test
    public void partitioningBy2() {
        final Map<Boolean, Optional<UserDTO>> collect = userDTOS.stream().collect(
                Collectors.partitioningBy(userDTO -> userDTO.getGender().equals(Gender.MALE),
                        Collectors.maxBy(Comparator.comparing(UserDTO::getAge))));
        final Map<Boolean, Optional<UserDTO>> collect2 = userDTOS.stream()
                .collect(Collectors.partitioningBy(userDTO -> userDTO.getGender().equals(Gender.MALE), Collectors.maxBy(Comparator.comparingInt(UserDTO::getAge))));

    }

    @Test
    public void map1() {
        /**
         * 多个 key 报错
         */
        userDTOS.add(UserDTO.builder().age(18).id(1).username("陈平安").gender(Gender.MALE).build());
        final Map<Integer, UserDTO> collect = userDTOS.stream().collect(Collectors.toMap(UserDTO::getId, Function.identity()));
    }

    @Test
    public void map2() {
        /**
         * 多个 key 报错
         */
        userDTOS.add(UserDTO.builder().age(20).id(1).username("陈平安").gender(Gender.MALE).build());
        userDTOS.add(UserDTO.builder().age(19).id(1).username("陈平安").gender(Gender.MALE).build());
        final Map<Integer, UserDTO> collect = userDTOS.stream().collect(Collectors.toMap(UserDTO::getId, Function.identity(), (t1, t2) -> {
            System.out.println(t1.getAge());
            System.out.println(t2.getAge());
            return t1;
        }));
        System.out.println(collect.keySet());
    }

    @Test
    public void run5() {
        final ArrayList<UserDTO> collect = userDTOS.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    public void run6() {
        IntSummaryStatistics collect = userDTOS.stream().collect(Collectors.summarizingInt(UserDTO::getId));
        final double average = collect.getAverage();
        System.out.println(average);
        System.out.println(collect.getCount());
        System.out.println(collect.getMax());
        System.out.println(collect.getMin());
        System.out.println(collect.getSum());
    }

    @Test
    public void reduce() {
        final Optional<UserDTO> collect = userDTOS.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(UserDTO::getId))));
        System.out.println(collect.get());
    }

    @Test
    public void reduce2() {
        final UserDTO build = UserDTO.builder().id(100).build();
        userDTOS.add(UserDTO.builder().id(105).build());
        UserDTO collect = userDTOS.stream().collect(Collectors.reducing(build, (t1, t2) -> {
            System.out.println(t1);
            System.out.println(t2);
            if (t1.getId() - t2.getId() > 0) {
                return t1;
            }
            return t2;
        }));
        System.out.println(collect);
    }

    @Test
    public void reduce3() {
        final UserDTO build = UserDTO.builder().id(100).build();
        userDTOS.add(build);
        final Integer collect = userDTOS.stream().collect(Collectors.reducing(90, UserDTO::getId, (t1, t2) -> {

            if (t1 - t2 > 0) {
                return t1;
            }
            return t2;
        }));
        System.out.println(collect);
    }
}
