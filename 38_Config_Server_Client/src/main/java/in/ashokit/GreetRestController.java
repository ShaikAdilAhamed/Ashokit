package in.ashokit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //if any propertiesare changed in the config server it will refresh and get the new properties from the config server
public class GreetRestController {
    
    @Value("${msg}")
    private String msg;

    @GetMapping("/")
    public String getGreetMsg() {
        return msg;  // This will return the value of 'msg' from the config server
    }
}