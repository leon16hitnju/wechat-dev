package org.itxuexi.controller;

import org.itxuexi.base.BaseInfoProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("g")
public class HelloController extends BaseInfoProperties {

    // 127.0.0.1:1000/g/hello
    @GetMapping("hello")
    public Object hello() {
        return "Hello Gateway~";
    }

    @GetMapping("setRedis")
    public Object setRedis(String k, String v){
        redis.set(k,v);
        return "setRedis done";
    }

    @GetMapping("getRedis")
    public Object getRedis(String k){
       return redis.get(k);
    }
}
