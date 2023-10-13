package org.example;

import java.io.File;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApplicationServerLauncher {

    private static final Logger logger = LoggerFactory.getLogger(
        WebApplicationServerLauncher.class);

    public static void main(String[] args) throws LifecycleException {
        final String webappDirLocation = "webapp/";
        final Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        logger.info("configuring app with baseDir: {}",
            new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }

}
