package com.chiliuliu.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.chiliuliu.common.entity.dto.StudentDto;
import com.chiliuliu.common.entity.po.Student;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class DtoEntityUtil {

    static Mapper mapper = new DozerBeanMapper();

    public static <D, E> E trans(D t, Class<E> clazz) {
        if (t == null) {
            return null;
        }
        return mapper.map(t, clazz);
    }

    public static <D, E> List<E> trans(D[] ts, Class<E> clazz) {
        List<E> es = new ArrayList<E>();
        if (ts == null) {
            return es;
        }
        for (D d : ts) {
            E e = (E) trans(d, clazz);
            if (e != null) {
                es.add(e);
            }
        }
        return es;
    }


    public static <D, E> List<E> trans(List<D> ts, Class<E> clazz) {
        List<E> es = new ArrayList<E>();
        if (ts == null) {
            return es;
        }
        for (D d : ts) {
            E e = (E) trans(d, clazz);
            if (e != null) {
                es.add(e);
            }
        }
        return es;
    }

    public static void main(String[] args) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId("123");
        studentDto.setCode("123");
        studentDto.setName("123");
        studentDto.setUserId("123");
        Student trans = DtoEntityUtil.trans(studentDto, Student.class);
        System.out.println(trans);
    }
}