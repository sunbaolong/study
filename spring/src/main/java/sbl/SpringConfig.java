package sbl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import sbl.aop.CountTool;
import sbl.cd.CDPlayer;
import sbl.cd.CompactDisc;
import sbl.cd.MediaPlayer;
import sbl.cd.SgtPeppers;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/2
 */
@Configuration
@ComponentScan("sbl")
@EnableAspectJAutoProxy
//@ImportResource("spring.xml")
public class SpringConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer cdPlayer() {
        return new CDPlayer();
    }

}
