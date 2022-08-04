package org.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.camel.model.Person;

public class SetDataExchageProcessor implements Processor{
    
    @Override
    public void process(Exchange exchange) throws Exception {
        Person person = new Person("Luis",24);
        exchange.getOut().setBody(person);
    }
}
