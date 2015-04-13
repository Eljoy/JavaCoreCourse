/**
 * Created by Home on 09.03.2015.
 */
import config.Config;
import config.R;
import org.apache.log4j.Logger;

public class TestClass {
    private static Logger logger = Logger.getLogger(TestClass.class);

    public static void main(String[] args) {

        Config config = new Config(R.Log.LOG_PROPERTIES_FILE);
        config.init();

        logger.info("Program has started");
        logger.info("Exception occurred : ", new Exception());
    }

}
