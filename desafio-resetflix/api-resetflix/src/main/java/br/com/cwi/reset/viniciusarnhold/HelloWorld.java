package br.com.cwi.reset.viniciusarnhold;

import br.com.cwi.reset.viniciusarnhold.exceptions.AtorAnoInicioAtividadeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorld {

    @GetMapping
    public String helloWorld() throws AtorAnoInicioAtividadeException {
        throw new AtorAnoInicioAtividadeException();
        //return "Hello World";
    }
}
