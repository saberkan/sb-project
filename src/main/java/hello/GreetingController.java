package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*; 

@RestController
public class GreetingController {

    private static final String template = "Hello v2, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static String response;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @GetMapping("/print-all-headers")
    public String getAllheaders(@RequestHeader Map<String,String> headers){
        response = "";
        headers.forEach((key,value) ->{
            System.out.println("Header Name: "+key+" Header Value: "+value);
            response += "Header Name: "+key+" Header Value: "+value+"<br>###################################<br>";
        });
        return response;
    }

}
