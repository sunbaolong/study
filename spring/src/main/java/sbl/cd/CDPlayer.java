package sbl.cd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/2
 */
@Component
public class CDPlayer implements MediaPlayer {

    @Autowired
    private CompactDisc cd;

    public void play() {
        cd.play();
    }
}
