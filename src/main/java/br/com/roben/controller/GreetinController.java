package br.com.roben.controller;


import br.com.roben.exceptions.UnsupportedMathOperationException;
import br.com.roben.model.Greeting;
import br.com.roben.model.Operetion;
import br.com.roben.validacao.StaticMethods;
import org.springframework.web.bind.annotation.*;

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



    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!StaticMethods.isNumeric(numberOne) || !StaticMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return new Operetion().soma(StaticMethods.covertToDouble(numberOne),StaticMethods.covertToDouble(numberTwo));


    }


    @RequestMapping(value="/subitracao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double subitracao(@PathVariable("numberOne") String numberOne,
                               @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!StaticMethods.isNumeric(numberOne) || !StaticMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return  new Operetion().subtracao(StaticMethods.covertToDouble(numberOne) , StaticMethods.covertToDouble(numberTwo));
    }



    @RequestMapping(value="/mutiplicacao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mutiplicacao(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!StaticMethods.isNumeric(numberOne) || !StaticMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return  new Operetion().mutiplicacao( StaticMethods.covertToDouble(numberOne) , StaticMethods.covertToDouble(numberTwo));
    }


    @RequestMapping(value="/divisao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double divisao(@PathVariable("numberOne") String numberOne,
                               @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!StaticMethods.isNumeric(numberOne) || !StaticMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return  new Operetion().divisao( StaticMethods.covertToDouble(numberOne) , StaticMethods.covertToDouble(numberTwo));
    }





    @RequestMapping(value="/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double media(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo)  throws Exception {

        if (!StaticMethods.isNumeric(numberOne) || !StaticMethods.isNumeric(numberTwo)     ) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return   new Operetion().media(StaticMethods.covertToDouble(numberOne) , StaticMethods.covertToDouble(numberTwo));
    }



    @RequestMapping(value="/raizquadrada/{numberOne}", method=RequestMethod.GET)
    public Double divisao(@PathVariable("numberOne") String numberOne) throws Exception {
        if (!StaticMethods.isNumeric(numberOne) ){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return  new Operetion().raizQuadrada(StaticMethods.covertToDouble(numberOne));
    }







}
