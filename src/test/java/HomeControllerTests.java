/*
 * Copyright (c) 2024.  Noxolo Mandisa Mkhungo
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ModelAndView;
import za.co.fynbos.controller.HomeController;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Noxolo.Mkhungo
 */
@Slf4j
class HomeControllerTests {

    @Mock
    private ResourceBundleMessageSource bundleMessageSource;

    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIndexWithDefaultLocale() {
        ModelAndView modelAndView = homeController.index(null);

        assertNotNull(modelAndView);
        assertEquals("index", modelAndView.getViewName());
    }

    @Test
    void testIndexWithSpecificLocale() {
        // Arrange
        String lang = "zu_ZA";
        Locale expectedLocale = Locale.forLanguageTag(lang);
        ModelAndView modelAndView = homeController.index(lang);

        assertNotNull(modelAndView);
        assertEquals("index", modelAndView.getViewName());
        assertEquals(expectedLocale, Locale.of(lang));
    }

}
