import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jConcept {

    static  Logger logger= LogManager.getLogger(log4jConcept.class);

    public static void main(String [] args)
    {


        logger.trace("This is trace");
        logger.info("This is information");
        logger.warn("This is Warning");
        logger.fatal("This is fatal");
        logger.error("This is error");

    }
}
