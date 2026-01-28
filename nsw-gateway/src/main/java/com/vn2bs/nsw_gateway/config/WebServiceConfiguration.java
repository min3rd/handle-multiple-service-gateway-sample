package com.vn2bs.nsw_gateway.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/web-services/*");
    }

    @Bean(name = "bct-thu-tuc-1")
    public DefaultWsdl11Definition BCT_ThuTuc1_defaultWsdl11Definition(@Qualifier("bct-schema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("schema");
        wsdl11Definition.setLocationUri("/web-services");
        wsdl11Definition.setTargetNamespace("com.vn2bs.webservices.bct.thutuc1");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean(name = "bct-messages")
    public DefaultWsdl11Definition BCT_Messages_defaultWsdl11Definition(
            @Qualifier("bct-messages-schema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BCTMessages");
        wsdl11Definition.setLocationUri("/web-services");
        wsdl11Definition.setTargetNamespace("com.vn2bs.webservices.bct.messages");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean(name = "bct-messages-schema")
    @Qualifier("bct-messages-schema")
    public XsdSchema BCT_Messages_schema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/bct/BCTMessages.xsd"));
    }

    @Bean(name = "bct-schema")
    @Qualifier("bct-schema")
    public XsdSchema BCT_ThucTuc1_schema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/bct/thutuc1.xsd"));
    }
}
