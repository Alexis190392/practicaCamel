package org.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.camel.model.Person;

public class ProcessDataExchangeProcessor implements Processor{
    
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("2. Body in= ");
        Person person = exchange.getIn().getBody(Person.class); //de esta manera traigo del body in la clase Person, caso de no poderlo transformar, lo indica como null
        //realizo validacion
        if(person != null){
            System.err.println("Nombre: " + person.getName());
        }else{
            System.err.println("Persona null");
        }
        
    }
    
}
