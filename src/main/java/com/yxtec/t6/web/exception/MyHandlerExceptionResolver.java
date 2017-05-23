package com.yxtec.t6.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jerrie on 17-5-22.
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHandlerExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOGGER.error(ex.getMessage(), ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("ex", ex);
        return modelAndView;
    }

}
