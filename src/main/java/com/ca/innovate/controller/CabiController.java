package com.ca.innovate.controller;

import com.ca.model.User;
import com.ca.services.RegistrationService;
import com.ca.services.ServiceFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static org.springframework.http.HttpMethod.GET;

/**
 * Created by talma07 on 1/9/2017.
 */

@RestController
@RequestMapping("v1/reports/")

public class CabiController {

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAllReports() {

        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + "c3VwZXJ1c2VyOnN1cGVydXNlcg==");

        HttpEntity<String> entity = new HttpEntity<>(headers);


//        ResponseEntity<String> response = restTemplate.exchange("http://batma06-i184915:8080/jasperserver-pro/rest_v2/resources??recursive=true&&type=reportUnit",

                ResponseEntity<String> response = restTemplate.exchange("http://batma06-i184915:8080/jasperserver-pro/rest_v2/resources??recursive=true&&type=reportUnit&&type=adhocDataView&&type=dashboard",
                GET, entity, String.class);


        return response.getBody();


    }


    @RequestMapping(value = "all/dasboards", method = RequestMethod.GET)
    public String getDashboards() {

        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + "c3VwZXJ1c2VyOnN1cGVydXNlcg==");

        HttpEntity<String> entity = new HttpEntity<>(headers);


//        ResponseEntity<String> response = restTemplate.exchange("http://batma06-i184915:8080/jasperserver-pro/rest_v2/resources??recursive=true&&type=reportUnit",

        ResponseEntity<String> response = restTemplate.exchange("http://batma06-i184915:8080/jasperserver-pro/rest_v2/resources??recursive=true&&type=dashboard",
                GET, entity, String.class);


        return response.getBody();


    }

    @RequestMapping(value = "all/views", method = RequestMethod.GET)
    public String getViews() {

        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + "c3VwZXJ1c2VyOnN1cGVydXNlcg==");

        HttpEntity<String> entity = new HttpEntity<>(headers);


//        ResponseEntity<String> response = restTemplate.exchange("http://batma06-i184915:8080/jasperserver-pro/rest_v2/resources??recursive=true&&type=reportUnit",

        ResponseEntity<String> response = restTemplate.exchange("http://batma06-i184915:8080/jasperserver-pro/rest_v2/resources??recursive=true&&type=adhocDataView",
                GET, entity, String.class);


        return response.getBody();


    }



}
