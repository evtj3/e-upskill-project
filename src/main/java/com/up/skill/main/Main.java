package com.up.skill.main;

import com.up.skill.model.ContentForm;
import com.up.skill.model.ContentRepository;
import javafx.application.Application;
import org.hibernate.bytecode.buildtime.spi.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by jejeTabadzki on 2/21/2017.
 */
/*
* TODO
* create a distinct main topic
 */
@Controller
public class Main {

    private ContentRepository contentRepository;

    @Autowired
    public Main(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView indexGet(ContentForm contentForm,
                                 ModelAndView modelAndView){

        List<String> mainTopics = new ArrayList<String>();
        for(int i=0;i < contentRepository.findAll().size();i++){
            mainTopics.add(i,contentRepository.findAll().get(i).getMainTopic());
        }
        Set<String> hashSetList = new HashSet<String>(mainTopics);
        modelAndView.addObject("contentFormDataTopic",hashSetList);
        modelAndView.addObject("contentFormData",contentRepository.findAll());
        modelAndView.addObject("contentForm",contentForm);
        modelAndView.setViewName("home/eHome");
        return  modelAndView;
    }
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public ModelAndView topicsGet(ModelAndView modelAndView, HttpServletRequest request){
        String req = request.getParameter("pages");
        List<String> reqData = new ArrayList<String>();
        List<String> topics = new ArrayList<String>();
        for(int y=0;y<contentRepository.findAll().size();y++){
            topics.add(y,contentRepository.findAll().get(y).getMainTopic());
        }
        Set<String> hashList = new HashSet<String>(topics);
        modelAndView.addObject("contentTopics",hashList);
        modelAndView.addObject("content",contentRepository.findByTitle(req));
        modelAndView.addObject("contentData",contentRepository.findAll());
        modelAndView.setViewName("topics/page");
        return modelAndView;
    }
    @RequestMapping(value = "/post" ,method = RequestMethod.POST)
    public void ajaxPost(@ModelAttribute @Valid ContentForm contentForm,
                          BindingResult bindingResult, HttpServletResponse response){
        try{
            PrintWriter writer = response.getWriter();
            //Writer writer = response.getWriter();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if(bindingResult.hasErrors()){
                writer.print("fail");
                //writer.print(bindingResult.getFieldError());
            }else{
                contentRepository.save(contentForm);
                writer.print("success");
            }
        }catch (Exception ex){

        }
    }
}
