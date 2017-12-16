package io.bluecolor.config

import scala.collection.JavaConversions._

import org.springframework.context.annotation.{Bean,Configuration}
import org.springframework.web.servlet.config.annotation.{
  WebMvcConfigurationSupport,
  CorsRegistry,
  ViewControllerRegistry,
  WebMvcConfigurerAdapter
}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import com.fasterxml.jackson.databind._

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.web.servlet.ErrorPage
import org.springframework.http.HttpStatus
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean


@Configuration
class MvcConfig extends WebMvcConfigurerAdapter{

  private class NotFoundIndexTemplate extends EmbeddedServletContainerCustomizer {
    override def customize(container: ConfigurableEmbeddedServletContainer): Unit = {
      container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"))
    }
  }

  @Bean
  def notFoundCustomizer: EmbeddedServletContainerCustomizer = {
      return new NotFoundIndexTemplate
  }


  override def addViewControllers(registry: ViewControllerRegistry ) {
    registry.addViewController("/home").setViewName("index");
    registry.addViewController("/").setViewName("index");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/forgot-password").setViewName("forgot-password");
  }

  @Bean
  def customJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter = {
    val jsonConverter= new MappingJackson2HttpMessageConverter
    val mapper = new ObjectMapper
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
    val module = new Hibernate5Module
    module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
    mapper.registerModule(module)
    mapper.registerModule(new DefaultScalaModule)

    jsonConverter.setObjectMapper(mapper)
    jsonConverter
  }

  override def configureMessageConverters(
    converters: java.util.List[HttpMessageConverter[_]]): Unit = {
    converters.add(customJackson2HttpMessageConverter())
  }

  @Bean
  def  messageSource: ReloadableResourceBundleMessageSource = {
    var messageBundle = new ReloadableResourceBundleMessageSource
    messageBundle.setBasename("classpath:messagess")
    messageBundle.setDefaultEncoding("UTF-8")
    messageBundle
  }

  @Bean
  override def getValidator = {
    val bean = new LocalValidatorFactoryBean
    bean.setValidationMessageSource(messageSource)
    bean
  }

}
