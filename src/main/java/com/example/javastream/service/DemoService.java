package com.example.javastream.service;

import com.example.javastream.model.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DemoService {

    public Object getDemo(){
        // 성별이 남성인경우만 출력
        List<Sample> sampleList = Sample.getSampleList().stream().filter(sample -> sample.getGender() == "M").collect(Collectors.toList());

        // 나이순으로 정렬
        List<Sample> sampleSortList = Sample.getSampleList().stream().sorted(Comparator.comparing(Sample::getAge)).collect(Collectors.toList());

        // 모든 사용자의 나이가 13세 이상인 경우 true
        boolean sampleAllMatch = Sample.getSampleList().stream().allMatch(Sample -> Sample.getAge() > 13);

        // 사용자의 나이중 13세 이상이 하나라도 있으면 true
        boolean sampleAnyMatch = Sample.getSampleList().stream().anyMatch(Sample -> Sample.getAge() > 13);

        // 사용자의 나이중 13세 이상이 하나라도 없으면 true
        boolean sampleNonMatch  = Sample.getSampleList().stream().noneMatch(Sample -> Sample.getAge() > 13);

        // 나이가 가장 많은 데이터 조회
        Optional<Sample> sampleMaxAge = Sample.getSampleList().stream().max(Comparator.comparing(Sample::getAge));
        if(sampleMaxAge.isPresent()){
            //return sampleMaxAge.get();
        }

        // 나이가 가장 적은 데이터 조회
        Optional<Sample> sampleMinAge = Sample.getSampleList().stream().min(Comparator.comparing(Sample::getAge));
        if(sampleMinAge.isPresent()){
            //return sampleMinAge.get();
        }

        // 성별로 그룹을 만들어 출력
        Map<String,List<Sample>> groupByGender = Sample.getSampleList().stream().collect(Collectors.groupingBy(Sample::getGender));
        groupByGender.forEach((gender,genderList) -> {
            //genderList.forEach(System.out::println);
        });

        // 여성중 나이가 가장 많은 사람 이름만 조회
        Optional<String> sampleMaxWomanName = Sample.getSampleList().stream().filter(sample ->sample.getGender().equals("F")).max(Comparator.comparing(Sample::getAge)).map(Sample::getName);


        return sampleMaxWomanName;
    }

}
