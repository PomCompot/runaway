package fr.pomcompot.sample.webapp.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class H2ServerLauncher implements ServletContextListener {
	private final Logger logger = LoggerFactory.getLogger(H2ServerLauncher.class);
	
	private Server tcpServer, webServer;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			tcpServer = Server.createTcpServer().start();
			logger.debug("TCP server URL: {}", tcpServer.getURL());
			logger.debug("TCP server status: {}", tcpServer.getStatus());
			
			webServer = Server.createWebServer().start();
			logger.debug("Web server URL: {}", webServer.getURL());
			logger.debug("Web server status: {}", webServer.getStatus());
			
			DriverManager.getConnection("jdbc:h2:mem:modernWebapp;TRACE_LEVEL_FILE=4;DB_CLOSE_DELAY=-1", "", "").close();
		} catch (SQLException e) {
			logger.error("Cannot start H2 Web server.", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (tcpServer != null) {
			tcpServer.stop();
		}
		if (webServer != null) {
			webServer.stop();
		}
	}
}
