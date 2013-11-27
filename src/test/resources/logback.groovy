// Built on Wed Mar 14 11:33:33 CET 2012 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import java.lang.management.ManagementFactory
import java.util.logging.Handler
import java.util.logging.LogManager

import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.jul.LevelChangePropagator
import ch.qos.logback.classic.jmx.MBeanUtil
import ch.qos.logback.classic.jmx.JMXConfigurator
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.status.OnConsoleStatusListener

import org.slf4j.bridge.SLF4JBridgeHandler

import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.WARN
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.TRACE

// always a good idea to add an on console status listener
statusListener(OnConsoleStatusListener)

scan("10 seconds")
context.name = "apache-tomcat"

// ------------------------------
// Code issu de http://www.mail-archive.com/logback-user@qos.ch/msg02978.html
// Non supporté nativement par le convertisseur logback

def contextListener = new LevelChangePropagator()
addInfo("Reseting JUL")
contextListener.resetJUL = true
// ------------------------------

// ------------------------------
// Enregistrement du SLF4JBridgeHandler

addInfo("Registering SLF4JBridgeHandler")
java.util.logging.Logger rootLogger = LogManager.getLogManager().getLogger("");
Handler[] handlers = rootLogger.getHandlers();
if (handlers != null ) {
    for (Handler handler : handlers) {
        rootLogger.removeHandler(handler);
    }
}
SLF4JBridgeHandler.install();
// ------------------------------

// ------------------------------
// Code issu de http://stackoverflow.com/questions/6232009/logback-groovy-config-to-use-jmx
// Non supporté nativement par le convertisseur logback
// 
//addInfo("Adding JMXConfigurator")
//def jmxConfigurator() {
//    def contextName = context.name
//    def objectNameAsString = MBeanUtil.getObjectNameFor(contextName, JMXConfigurator.class)
//    def objectName = MBeanUtil.string2ObjectName(context, this, objectNameAsString)
//    def platformMBeanServer = ManagementFactory.getPlatformMBeanServer()
//    if (!MBeanUtil.isRegistered(platformMBeanServer, objectName)) {
//        JMXConfigurator jmxConfigurator = new JMXConfigurator((LoggerContext) context, platformMBeanServer, objectName)
//        try {
//            platformMBeanServer.registerMBean(jmxConfigurator, objectName)
//        } catch (all) {
//            addError("Failed to create mbean", all)
//        }
//    }
//}
//
//jmxConfigurator()
// ------------------------------

appender("console", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "[@/%contextName] %date{HH:mm:ss,SSS} %-5level %thread:%mdc{sessionId}[%logger] %msg%n"
  }
}

logger("org.springframework", DEBUG)
logger("com.h2database", INFO)
logger("liquibase", INFO)

root(INFO, ["console"])
