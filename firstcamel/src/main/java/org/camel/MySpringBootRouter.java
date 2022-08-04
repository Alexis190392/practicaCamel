package org.camel;



import org.camel.processor.ProcessData;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.camel.model.Entry;
import org.camel.model.Root;
import org.camel.processor.ProcessDataExchangeProcessor;
import org.camel.processor.SetDataExchageProcessor;
import org.springframework.stereotype.Component;

@Component
public class MySpringBootRouter extends RouteBuilder {
    //para utilidar el dataformat
    private JacksonDataFormat jdf;

    public MySpringBootRouter() {
        jdf = new JacksonDataFormat(Root.class);
        
    }
    
    

    @Override
    public void configure() {
        
        from("timer:hello?period={{timer.period}}")
                //.log("disparador \n")
                //.process(new SetDataExchageProcessor())
                .to("direct:consumir") //va al endpoint detallado
                .end();
        

        from("direct:procesarMensaje")
                .log("inicia procesamiento de mensaje")
                .process(new ProcessDataExchangeProcessor())
                .end();
        
        //consumir desde https://api.publicapis.org/entries
        from("direct:consumir") 
                .setHeader(Exchange.HTTP_METHOD,constant("GET")) //establece un header con metodo get
                .to("https://api.publicapis.org/entries") //invoca al recurso
                .unmarshal(jdf) //para lo que ingrese de la uri y llame al dataformat // 
                .process(new ProcessData()) //procede a obtener como objeto
                .end();
    }

}
