package com.ca.services;

import com.ca.model.Group;
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

        //String KEY = "AIzaSyAUjkefu1QPuxCUm_oqgTfMno9HTWrKZng";
        String KEY = "AIzaSyDEzR7s9X4I09v_Vc_pydD7SfaAeV2aA0M";
        GooglePlaces google = null;
        try {

            google = new GooglePlaces(KEY);
            google.setDebugModeEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //google.getPlacesByQuery(TEST_PLACE_NAME, GooglePlacesInterface.MAXIMUM_RESULTS), TEST_PLACE_NAME)
        List<Place> nearByPlaces = google.getNearbyPlaces(Double.parseDouble(longitude),Double.parseDouble(latitude), 200);
       List<Place> sortedPlaces = new ArrayList<>();

        for(Place p :nearByPlaces)
        {
            /*p.getTypes().contains()*/
           boolean isLocality = false;
            List<String> typeList = p.getTypes();
            for(String type:typeList)
            {
                if (type.contains(("locality")))
                {
                    isLocality = true;
                    break;
                }
            }
            if(! isLocality)
            {
                sortedPlaces.add(p);
            }
        }
        List<Group> glist = new ArrayList<>();

        for (Place place : sortedPlaces) {
            GroupDAO grpDao = new GroupDAOImpl();
            Group g = grpDao.findByGroupId(place.getPlaceId());
            if (g == null) {
                Group newGrp = new Group();
                newGrp.setGpsLatitude(place.getLatitude() + "");
                newGrp.setGpsLongitude(place.getLongitude() + "");
                newGrp.setGroupAddress(place.getVicinity());
                newGrp.setGroupId(place.getPlaceId());
                newGrp.setTimeStamp(System.currentTimeMillis() + "");
                newGrp.setType(place.getTypes().get(0));
                newGrp.setUuid(UUID.randomUUID() + "");
                newGrp.setGroupName(place.getName());
             //   newGrp.setGroupAddress(place.get);
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
        if(glist.size()>5)
        {
            glist = glist.subList(0,5);
        }
        return glist;
    }
}
