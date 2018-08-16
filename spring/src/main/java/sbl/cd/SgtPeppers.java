package sbl.cd;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/2
 */
@Component
public class SgtPeppers implements CompactDisc {

    public void play() {
        System.out.println("SgtPeppers");
    }

}
