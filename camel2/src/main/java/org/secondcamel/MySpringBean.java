package org.secondcamel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MySpringBean {

    @Value("${greeting}")
    private String say;

    public String saySomething() {
        return say;
    }

}
