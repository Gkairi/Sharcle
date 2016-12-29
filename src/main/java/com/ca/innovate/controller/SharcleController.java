package com.ca.innovate.controller;

import com.ca.innovate.controller.model.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by talma07 on 12/28/2016.
 */

@RestController
@RequestMapping("api/v1/sharcle/")


public class SharcleController {


    @RequestMapping(value = "user", method = RequestMethod.POST)

    public UserDetails create(@RequestBody UserDetails user) {

        return new UserDetails().dummy();


    }

    @RequestMapping(value = "user/allusers", method = RequestMethod.GET)

    public UserDetails getUser() {
        UserDetails userDetails = new UserDetails();
        return userDetails.dummy();


    }
}
