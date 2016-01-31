package com.shardis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.util.Date;

/**
 * Created by Tomasz Kucharzyk
 */
@Controller
public class AppController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    @Qualifier("reactScriptEngine")
    ScriptEngine reactScriptEngine;

    @Autowired
    @Qualifier("preactScriptEngine")
    ScriptEngine preactScriptEngine;


    @RequestMapping("/")
    String index() throws Exception {
        return "index";
    }

    @RequestMapping("/react")
    String react(Model model) throws Exception {
        Date date = new Date();
        Object markup = ((Invocable) reactScriptEngine).invokeFunction("renderOnServer", "SERVER:" + date.toString());
        model.addAttribute("markup", markup);
        model.addAttribute("initialData", objectMapper.writeValueAsString("CLIENT:" + date.toString()));
        return "react";
    }

    @RequestMapping("/preact")
    String preact(Model model) throws Exception {
        Date date = new Date();
        Object markup = ((Invocable) preactScriptEngine).invokeFunction("renderOnServer", "SERVER:" + date.toString());
        model.addAttribute("markup", markup);
        model.addAttribute("initialData", objectMapper.writeValueAsString("CLIENT:" + date.toString()));
        return "preact";
    }
}
