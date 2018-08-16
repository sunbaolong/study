package spittr.service;

import org.springframework.stereotype.Component;
import spittr.entity.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/15
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        spittles.add(new Spittle("今天是个好天气！", new Date(), 100.0, 200.0));
        spittles.add(new Spittle("我想去游泳！", new Date(), 101.0, 100.0));
        spittles.add(new Spittle("我正在加班！", new Date(), 110.0, 300.0));
        return spittles;
    }
}
