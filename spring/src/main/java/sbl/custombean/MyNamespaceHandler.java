package sbl.custombean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/8/14
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
