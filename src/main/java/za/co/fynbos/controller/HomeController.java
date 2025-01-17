/*
 * Copyright (c) 2024.  Noxolo Mandisa Mkhungo
 */

package za.co.fynbos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * @author Noxolo.Mkhungo
 */
@Slf4j
@Controller
public class HomeController {
    @SuppressWarnings("unsed")
    private final ResourceBundleMessageSource bundleMessageSource;
    @Autowired
    public HomeController(@Qualifier("messageSource")ResourceBundleMessageSource  bundleMessageSource){
        this.bundleMessageSource=bundleMessageSource;
    }
    @GetMapping("/")
    public ModelAndView index(@RequestParam(name = "lang",required = false)String localParam){
        Locale locale = Locale.getDefault();
        if(localParam != null && !localParam.isEmpty()){locale= Locale.forLanguageTag(localParam);}
        log.info("Welcome home! The client locale is {}.", locale);
        String welcomeMessage = bundleMessageSource.getMessage("welcome.message", null, locale);
        String hello = bundleMessageSource.getMessage("hello", null, locale);
        String world = bundleMessageSource.getMessage("world", null, locale);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("welcome.message", welcomeMessage);
        modelAndView.addObject("hello", hello);
        modelAndView.addObject("world", world);
        return modelAndView;
    }
}
