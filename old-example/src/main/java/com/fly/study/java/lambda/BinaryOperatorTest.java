package com.fly.study.java.lambda;

import com.fly.study.java.lambda.enitity.Gender;
import com.fly.study.java.lambda.enitity.UserDTO;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author 张攀钦
 * @date 2019-09-27-13:08
 * @description BinaryOperator api
 */
public class BinaryOperatorTest {
    @Test
    public void run1() {
        BinaryOperator<Integer> binaryOperator= (t1,t2)->t2-t1;
        System.out.println(binaryOperator.apply(3, 2));
    }

    @Test
    public void run2() {
        final UserDTO userDTO1 = UserDTO.builder().age(18).id(1).username("陈平安").gender(Gender.MALE).build();
        final UserDTO userDTO2 = UserDTO.builder().age(19).id(2).username("宁姚").gender(Gender.FEMALE).build();
        Comparator<UserDTO> comparator=(t1,t2)->t1.getId()-t2.getId();
        final BinaryOperator<UserDTO> objectBinaryOperator = BinaryOperator.maxBy(comparator);
        System.out.println(objectBinaryOperator.apply(userDTO1, userDTO2));
    }
    @Test
    public void run3() {
        final UserDTO userDTO1 = UserDTO.builder().age(18).id(1).username("陈平安").gender(Gender.MALE).build();
        final UserDTO userDTO2 = UserDTO.builder().age(19).id(2).username("宁姚").gender(Gender.FEMALE).build();
        final BinaryOperator<UserDTO> objectBinaryOperator = (t1,t2)->  {
            int id1 = t1.getId();
            int id2=t2.getId();
            if((id1-id2)<0){
                return t2;
            }
            return t1;
        };
        System.out.println(objectBinaryOperator.apply(userDTO1, userDTO2));
    }
}
