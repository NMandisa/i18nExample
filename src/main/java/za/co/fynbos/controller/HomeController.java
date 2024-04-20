package za.co.fynbos.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Noxolo.Mkhungo
 */
@Controller
public class HomeController {
    private ResourceBundleMessageSource messageSource;
    public void setMessageSource(@Qualifier("webMessageSource") ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String index(){
        return "index";
    }
}
