package spittr.service;

import spittr.entity.Spittle;

import java.util.List;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/15
 */
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

}
