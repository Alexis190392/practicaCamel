package org.secondcamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.secondcamel.model.Users;
import org.springframework.stereotype.Component;

@Component
public class ProcessRequestPostUsers implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {
        
        Users users = exchange.getIn().getBody(Users.class);
        System.err.println("Total de usuarios: " + users.getUsers().size());
    }
    
}
