package org.camel.processor;

import java.util.ArrayList;
import java.util.List;
import org.camel.model.*;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessData implements Processor{
    
    @Override
    public void process(Exchange exchange) throws Exception{
        //System.out.println("Body: " + exchange.getIn().getBody(String.class)); //se añade string class para que me lo muestre como string
        Root entrada = exchange.getIn().getBody(Root.class);
        if(entrada != null){
            System.out.println("entrada OK \n");
            for (Entry entry : entrada.getEntries()) {
                System.out.println("     " + entry.getApi() + "     " + entry.getLink());
            }

                
            
        }else{
            System.err.println("entrada null");
        }
    }
    
}
