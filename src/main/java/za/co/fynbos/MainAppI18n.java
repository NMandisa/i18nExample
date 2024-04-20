package za.co.fynbos;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Noxolo.Mkhungo
 *
 */
@Slf4j
public class MainAppI18n {
	public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
        ResourceBundleMessageSource messageSource = context.getBean("messageSource",ResourceBundleMessageSource.class);
		//log.info("Hello, World!");
		//default locale
        log.info(messageSource.getMessage("Hello", null, Locale.of("en", "US"))+" " + messageSource.getMessage("World", null, Locale.of("en", "US")));
        //ResourceBundleMessageSource bundle = messageSource.setBundleClassLoader("base",  Locale.of("en", "US"));
        //Get ResourceBundle with Locale that are already defined
        log.info(messageSource.getMessage("Hello", null, Locale.of("de", "DE"))+" " + messageSource.getMessage("World", null, Locale.of("de", "DE")));
        //ResourceBundle bundleDE = ResourceBundle.getBundle("base", Locale.of("de", "DE"));
        //Get resource bundle when Locale needs to be created
        //ResourceBundle bundleZA = ResourceBundle.getBundle("base", Locale.of("zu", "ZA"));
        log.info(messageSource.getMessage("Hello", null, Locale.of("zu", "ZA"))+" " + messageSource.getMessage("World", null, Locale.of("zu", "ZA")));

        //lets print some messages
        /*printMessages(bundle);
        printMessages(bundleDE);
        printMessages(bundleZA);*/
        
    }

    private static void printMessages(ResourceBundle bundle) {
        log.info(bundle.getString("Hello")+" ");
        log.info(bundle.getString("World"));
        log.info(".......................");
    }


}
