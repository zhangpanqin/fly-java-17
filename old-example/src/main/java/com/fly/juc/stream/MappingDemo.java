package com.fly.juc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MappingDemo {
    public static void main(String[] args) {
        final Student student1 = new Student("1",1);
        final Student student2 = new Student("2",2);
        final Student student3 = new Student("3",3);

        final List<Student> students = Arrays.asList(student1, student2, student3);
        final Map<String, List<Student>> collect = students.stream().collect(Collectors.mapping(Function.identity(), Collectors.groupingBy(Student::getName)));
    }
}

@Data
@AllArgsConstructor
class Student implements Serializable {
    private static final long serialVersionUID = -3283024661430016633L;
    private String name;
    private Integer age;
}