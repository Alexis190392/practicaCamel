package org.secondcamel.processor;

import java.util.ArrayList;
import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.secondcamel.model.User;
import org.secondcamel.model.Users;
import org.springframework.stereotype.Component;

@Component
public class ProcessRequestGetUsers implements Processor{
    
    @Override
    public void process(Exchange exchange) throws Exception{
        /**
         * Obtener parametros de entrada
         * 
         *          .get("/users/{id_user}")
         */
        Integer userId = exchange.getIn().getHeader("id_user", Integer.class);
        System.err.println("Header con id_user de entrada --> " + userId);
        
        
        Users users = new Users();
        List<User> listUser = new ArrayList<>();
        
        users.setUsers(listUser);
        
        User user = new User();
        user.setName("Alexis Dávila");
        user.setAge(30);
        
        
        listUser.add(user);
        
        exchange.getOut().setBody(users);
        /**
         * responder valores mediante header
         */
        exchange.getOut().setHeader("ID_USER_IN", "id_user => " + userId);
    }
    
}
