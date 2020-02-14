//IntelliJ IDEA
//batch
//Person
//2020/2/14
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.batch.domain;

import javax.validation.constraints.Size;

public class Person {
    // 用 JSR-303 注解校验数据
    @Size(max = 4,min = 2)
    private String name;
    private int age;
    private String nation;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }
}
