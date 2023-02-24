package com.fly.study.java.generics;

import lombok.Data;
import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-09-16-00:01
 * @description 父接口
 */
@Data
public class ArgsParent implements Serializable {
    private static final long serialVersionUID = 1455539535851014461L;
    private String name;
}
