package com.technolyne.springsoap.config

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition
import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.xml.xsd.XsdSchema

@Configuration
@EnableWs
class WebServiceConfig {


    @Bean
    fun messageDispatcherServlet(applicationContext: ApplicationContext):ServletRegistrationBean<MessageDispatcherServlet>{
        val servlet = MessageDispatcherServlet()
        servlet.setApplicationContext(applicationContext)
        servlet.isTransformWsdlLocations=true
        return ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*")
    }


    @Bean(name = ["film"])
    fun defaultWsdl11Definition(schema: XsdSchema):DefaultWsdl11Definition{
        val  defaultWsdl11Definition = DefaultWsdl11Definition()
        defaultWsdl11Definition.setLocationUri("/ws")
        defaultWsdl11Definition.setTargetNamespace("http://www.technolyne.com/film")
        defaultWsdl11Definition.setPortTypeName("film")
        defaultWsdl11Definition.setSchema(schema)
        return defaultWsdl11Definition
    }


    @Bean
    fun schema():XsdSchema{
        return SimpleXsdSchema(ClassPathResource("film.xsd"))
    }

}