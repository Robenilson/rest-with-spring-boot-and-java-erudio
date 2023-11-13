package br.com.roben.controller;


import br.com.roben.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetinController {

    private  static String TEMPLAITE=" Hellou  %S! ";
    private final  AtomicLong count  =  new AtomicLong();


    @RequestMapping
    public  Greeting  greeting(
            @RequestParam ( value =  "nome", defaultValue ="Word")  String nome ){

        return  new Greeting( count.incrementAndGet(), String.format(TEMPLAITE, nome));
    }
}
