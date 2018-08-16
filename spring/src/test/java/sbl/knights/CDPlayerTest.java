package sbl.knights;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbl.SpringConfig;
import sbl.cd.CDPlayerConfig;
import sbl.cd.CompactDisc;
import sbl.cd.MediaPlayer;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc disc;

    @Test
    public void cdNotBeNull() {
        disc.play();
        assertNotNull(disc);
    }

    @Test
    public void play() {
        player.play();
    }
}
