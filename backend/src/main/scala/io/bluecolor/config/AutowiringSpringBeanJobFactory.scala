package io.bluecolor.config


import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

import scala.collection.JavaConversions._

class AutowiringSpringBeanJobFactory extends  ApplicationContextAware {

  @transient private var beanFactory: AutowireCapableBeanFactory = _

  override def setApplicationContext(context: ApplicationContext): Unit = {
    beanFactory = context.getAutowireCapableBeanFactory
  }


}
