package io.pivotal.app.auto.metrics;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.core.env.Environment;
import org.springframework.boot.json.*;
import java.util.Map;

/**
 * Created by slhommedieu on 6/7/17.
 */

@RestController
public class InfoEndpointController {

    @Autowired
    private CounterService counterService;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/appinfo", method = RequestMethod.GET, produces = "application/json")
    public String getAppInfo() {

	org.springframework.boot.json.JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> result = springParser.parseMap(environment.getProperty("VCAP_APPLICATION"));
        String app_id = (String)result.get("application_id");

	counterService.increment("meter."+app_id+".getappinfo_calls");
        return "{\"Version\": 0.0.1}";
    }
}
