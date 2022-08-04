package org.camel;


import org.apache.camel.builder.RouteBuilder;
import org.camel.processor.ProcessDataExchangeProcessor;
import org.camel.processor.SetDataExchageProcessor;
import org.springframework.stereotype.Component;

@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        
        from("timer:hello?period={{timer.period}}")
                .log("disparador \n")
                .process(new SetDataExchageProcessor())
                .to("direct:procesarMensaje") //va al endpoint detallado
                .end();
        

        from("direct:procesarMensaje")
                .log("inicia procesamiento de mensaje")

                .process(new ProcessDataExchangeProcessor())
                .end();
                
    }

}
