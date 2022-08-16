package org.secondcamel;

import org.apache.camel.Exchange;
import org.secondcamel.processor.ProcessRequestPostUsers;
import org.secondcamel.processor.ProcessRequestGetUsers;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.secondcamel.model.User;
import org.secondcamel.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySpringBootRouter extends RouteBuilder {

    @Autowired
    private ProcessRequestGetUsers prgu;
    @Autowired
    private ProcessRequestPostUsers prpu;

    private JacksonDataFormat jsonUser = new JacksonDataFormat(Users.class);

    @Override
    public void configure() {
        
        //onException(exception) ----->
        /*
            Configurqacion de componente rest
         */
        restConfiguration() //se empieza a configurar un componente rest para hacer uso de endpoints a partir de REST
                .component("jetty") //componente a utilizar //jetty: servidor
                .enableCORS(true) //permite el acceso de recursos crusados http
                .port(10000) //puerto con el que va a trabajar
                .corsHeaderProperty("Access-Control-Allow-Origin", "*") //habilitar las ip de las cuales quiero consumir separadas por coma. * es para todas
                .corsHeaderProperty("Access-Control-Allow-Headers", "*");   //permite definir que tipo de headers pueden invocarse. Accept,Content-Type

        /**
         * Definicion de recursos...
         */
        /**
         * se define, mediante el metodo .get, acceder a la uri /users y apenas
         * llegue una petision al endpoint se enruta a una ruta de procesamiento
         * processGetUser
         */
        rest("ws_rest_camel") //pack de acceso a los recursos
                .get("/users") //.get("/users/{id_user}") en el caso de querer ingresar por parametro
                .route()
                .to("direct:processGetUser");
        
        from("direct:processGetUser")
                .log("Prosesando new Request")
                //.setBody(constant("REQUEST PROCESADA OK"))
                .process(prgu)
                .marshal(jsonUser)
                .end();


        /**
         * Para post
         */
        rest("ws_rest_camel")
                .post("/users")
                .route()
                .to("direct:processPostUser");

        from("direct:processPostUser")
                .log("Procesando POST")
                .choice()
                    .when(body().isNull())
                        .unmarshal(jsonUser)
                        .process(prpu)
                    .otherwise()
                        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("400"))
                    .endChoice()
                .end();
    }
}
