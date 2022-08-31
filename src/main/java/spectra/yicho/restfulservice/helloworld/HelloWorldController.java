package spectra.yicho.restfulservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    // GET방식의 메서드

    // hello - world(endPoint)
    @GetMapping(path ="/hello-world")
    public String helloWorld() {

        return "Hello Spectra";
    }

    // alt + enter
    @GetMapping(path ="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello Bean","inMyPocket");
    }

    @GetMapping(path ="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean("Hello Bean",String.format("inMyPocket, %s", name));
    }

    @GetMapping(path = "/hello-world-internationlized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        System.out.println("////ll");
        System.out.println(locale+"////ll");
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
