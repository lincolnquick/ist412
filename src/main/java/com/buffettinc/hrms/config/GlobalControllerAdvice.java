package com.buffettinc.hrms.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("currentPage")
    public String currentPage(HttpServletRequest request) {
        return request.getRequestURI();
    }
}

