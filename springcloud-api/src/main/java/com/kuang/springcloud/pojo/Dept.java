package com.kuang.springcloud.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dept")
@Data
@Accessors(chain = true) // 链式编程
public class Dept implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "deptno")
    private Long deptno;

    @Column(name = "deptname")
    private String deptName;

    /**
     * 这个数据存在哪个数据库的字段；微服务中，一个服务对应一个数据库，同一个信息可能存在不同的数据库中
     */
    @Column(name = "db_source")
    private String dbSource;
}
