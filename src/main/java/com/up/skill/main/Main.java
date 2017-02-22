package com.up.skill.main;

import com.up.skill.model.ContentForm;
import com.up.skill.model.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

/**
 * Created by jejeTabadzki on 2/21/2017.
 */
@Controller
public class Main {

    private ContentRepository contentRepository;
    @Autowired
    public void main(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView indexGet(@ModelAttribute @Valid ContentForm contentForm, Principal principal,
                                 ModelAndView modelAndView,BindingResult bindingResult){
        modelAndView.addObject("contentForm",contentForm);
        //if(principal != null)

        modelAndView.setViewName("home/eHome");
        return  modelAndView;
    }
    @RequestMapping(value = "/post" ,method = RequestMethod.POST)
    public void ajaxPost(@ModelAttribute @Valid ContentForm contentForm,
                          BindingResult bindingResult, HttpServletResponse response){
        try{
            PrintWriter writer = response.getWriter();
            //Writer writer = response.getWriter();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if(!bindingResult.hasErrors()){
                writer.print(fieldErrors);
            }else{
                writer.print("successful!");
            }
        }catch (Exception ex){

        }
    }
}
