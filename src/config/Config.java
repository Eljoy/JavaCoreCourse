package config;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Home on 4/13/2015.
 */
public class Config {
    private static Properties logproperty = new Properties();
    private static String logFile;
    @SuppressWarnings("static-access")
    public Config(String logFile){
        this.logFile = logFile;
    }

    public void init(){
        try {
            logproperty.load(new FileInputStream(logFile));
            PropertyConfigurator.configure(logproperty);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
