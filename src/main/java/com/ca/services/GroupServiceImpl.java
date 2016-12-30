package com.ca.services;

import com.ca.dao.Group;
import com.ca.dao.GroupDAO;
import com.ca.dao.GroupDAOImpl;
import com.ca.innovation.places.GooglePlaces;
import com.ca.innovation.places.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by indka01 on 12/29/2016.
 */
public class GroupServiceImpl implements GroupService {
    @Override
    public List<Group> getGroupList(String latitude, String longitude) {

        String KEY = "AIzaSyAUjkefu1QPuxCUm_oqgTfMno9HTWrKZng";
        GooglePlaces google = null;
        try {

            google = new GooglePlaces(KEY);
            google.setDebugModeEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //google.getPlacesByQuery(TEST_PLACE_NAME, GooglePlacesInterface.MAXIMUM_RESULTS), TEST_PLACE_NAME)
        List<Place> nearByPlaces = google.getNearbyPlaces(17.4254, 78.3372, 200);
        List<Group> glist = new ArrayList<>();

        for (Place place : nearByPlaces) {
            GroupDAO grpDao = new GroupDAOImpl();
            Group g = grpDao.findByGroupId(place.getPlaceId());
            if (g == null) {
                Group newGrp = new Group();
                newGrp.setGpsLatitude(place.getLatitude() + "");
                newGrp.setGpsLongitude(place.getLongitude() + "");
                newGrp.setGroupAddress(place.getAddress());
                newGrp.setGroupId(place.getPlaceId());
                newGrp.setTimeStamp(System.currentTimeMillis() + "");
                newGrp.setType(place.getTypes().get(0));
                newGrp.setUuid(UUID.randomUUID() + "");
                newGrp.setGroupName(place.getName());
                if (grpDao.save(newGrp)) {
                    glist.add(newGrp);
                }
            } else {
                glist.add(g);
            }
        }

        for (Group group : glist) {
            //place.getVicinity();
            System.out.println("######################");
            System.out.println(group.getGroupId());
            System.out.println(group.getGroupName());
            System.out.println("######################");
        }
        return glist;
    }
}
