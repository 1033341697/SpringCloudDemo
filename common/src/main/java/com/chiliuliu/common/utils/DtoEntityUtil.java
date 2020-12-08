package com.chiliuliu.common.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoEntityUtil {

    private static Mapper mapper = new DozerBeanMapper();

    public <D, E> E trans(D t, Class<E> clazz) {
        if (t == null) {
            return null;
        }
        return mapper.map(t, clazz);
    }

    public <D, E> List<E> trans(D[] ts, Class<E> clazz) {
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


    public <D, E> List<E> trans(List<D> ts, Class<E> clazz) {
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
}