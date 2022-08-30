package spectra.yicho.restfulservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

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

}
