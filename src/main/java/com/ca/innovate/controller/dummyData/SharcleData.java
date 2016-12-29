package com.ca.innovate.controller.dummyData;

import com.ca.innovate.controller.model.UserDetails;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by talma07 on 12/29/2016.
 */
public class SharcleData {

    private static
    Map<Integer, UserDetails> userMap = new HashMap<Integer, UserDetails>();

    public static void put(Integer id, UserDetails userDetails) {
        userMap.put(id, userDetails);
    }

    public static UserDetails get(Integer id) {
        return userMap.get(id);
    }
}
