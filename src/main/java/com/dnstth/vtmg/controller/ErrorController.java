package com.dnstth.vtmg.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

/**
 * @author Denes Toth
 */
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = Exception.class)
    public String handleError(Model model, Exception e) throws Exception {
        StringBuilder sb = new StringBuilder(e.toString());
        sb.append("<br />");

        Arrays.stream(e.getStackTrace()).forEach(sse ->
        {
            sb.append(sse);
            sb.append("<br />");
        });

        model.addAttribute("errorMsg", sb.toString());
        return "error";
    }
}
