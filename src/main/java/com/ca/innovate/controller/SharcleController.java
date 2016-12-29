package com.ca.innovate.controller;

import com.ca.innovate.controller.dummyData.SharcleData;
import com.ca.innovate.controller.model.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Created by talma07 on 12/28/2016.
 */

@RestController
@RequestMapping("api/v1/sharcle/")


public class SharcleController {


    @RequestMapping(value = "user", method = RequestMethod.POST)
    public UserDetails create(@RequestBody UserDetails userDetails) {
        userDetails.setId(userDetails.getEmail().hashCode());
        SharcleData.put(userDetails.getEmail().hashCode(), userDetails);

        return userDetails;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public UserDetails getUser(@PathVariable Long id) {
        UserDetails userDetails = new UserDetails();
        return userDetails.dummy();


    }
}
