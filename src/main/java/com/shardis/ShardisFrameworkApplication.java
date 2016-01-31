package com.shardis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.script.ScriptEngine;

/**
 * Created by Tomasz Kucharzyk
 */
@SpringBootApplication
public class ShardisFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardisFrameworkApplication.class, args);
    }

    @Bean(name = "reactScriptEngine")
    public ScriptEngine reactScriptEngine() {
        return new JavaScriptEngine()
            .polyfill()
            .load("static/dist/react.bundled.js")
            .get();
    }

    @Bean(name = "preactScriptEngine")
    public ScriptEngine preactScriptEngine() {
        return new JavaScriptEngine()
            .polyfill()
            .load("static/dist/preact.bundled.js")
            .get();
    }


}
