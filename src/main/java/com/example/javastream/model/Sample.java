package com.example.javastream.model;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Sample {

    public Sample(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private String id;
    private String name;
    private int age;
    private String gender;

    public static List<Sample> getSampleList(){
        return Arrays.asList(
                new Sample("aaa","홍길동1",10,"M"),
                new Sample("ccc","홍길동3",14,"M"),
                new Sample("bbb","홍길동2",12,"F"),
                new Sample("ddd","홍길동4",19,"M")
        );
    }


}
