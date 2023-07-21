package com.buffettinc.hrms.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * This class add an attribute called "currentPage" to each of the controllers so that the navbar Thymeleaf fragment
 * can determine which page is active.
 *
 * @author IST412 Group 5
 * @since 2023-07-21
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("currentPage")
    public String currentPage(HttpServletRequest request) {
        return request.getRequestURI();
    }
}

