package za.co.fynbos.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Noxolo.Mkhungo
 *
 */
public class MainAppI18n {
	
	public static void main(String[] args){

		System.out.println("Hello, World!");
		
		//default locale
        ResourceBundle bundle = ResourceBundle.getBundle("i18n");
        //Get ResourceBundle with Locale that are already defined
        ResourceBundle bundleFR = ResourceBundle.getBundle("i18n", Locale.GERMANY);
        //Get resource bundle when Locale needs to be created
        ResourceBundle bundleZA = ResourceBundle.getBundle("i18n", new Locale("zu", "ZA"));
        
        //lets print some messages
        printMessages(bundle);
        printMessages(bundleFR);
        printMessages(bundleZA);
        
    }

    private static void printMessages(ResourceBundle bundle) {
        System.out.print(bundle.getString("Hello")+" ");
        System.out.print(bundle.getString("World"));
        System.out.println(".......................");
    }
	

}
