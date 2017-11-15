package log4j;


import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 * Created by sunbaolong on 2017/11/13.
 */
public class Test {

    private static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        MDC.put("traceId", 1000);

        logger.debug("i am debug");
        logger.error("i am error");
        logger.info("i am info");
    }

}
