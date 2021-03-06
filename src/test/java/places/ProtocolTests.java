package places;

import com.ca.innovation.places.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;

/**
 * Tests written to mirror the official API guides found at:
 *
 * https://developers.google.com/places/web-service/search
 */
@Ignore
public class ProtocolTests {
    private static final String API_KEY_FILE_NAME = "places_api.key";
    private static final String UVM_NAME = "University of Vermont";
    private static final double UVM_LAT = 44.477321;
    private static final double UVM_LNG = -73.197292;
   // private static final String KEY = "AIzaSyAUjkefu1QPuxCUm_oqgTfMno9HTWrKZng";
    private static final String KEY ="AIzaSyDEzR7s9X4I09v_Vc_pydD7SfaAeV2aA0M";
    private GooglePlaces google;

    @Before
    public void setUp() {
        System.out.println("---- Initializing tests ----");
        try {
           /* InputStream in = ProtocolTests.class.getResourceAsStream("/" + API_KEY_FILE_NAME);
            if (in == null)
                fail("API key not found");*/
            google = new GooglePlaces(KEY);
            google.setDebugModeEnabled(true);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testNearbySearch() {
        System.out.println("---- Nearby Search ---");
        List<Place> places = google.getNearbyPlaces(UVM_LAT, UVM_LNG, GooglePlacesInterface.MAXIMUM_RADIUS, TypeParam.name("types").value(Types.TYPE_UNIVERSITY));
        assertContainsPlace(places, UVM_NAME);
        testTextSearch();
    }

    public void testTextSearch() {
        System.out.println("---- Text Search ----");
        List<Place> places = google.getPlacesByQuery(UVM_NAME, GooglePlacesInterface.MAXIMUM_RESULTS);
        assertContainsPlace(places, UVM_NAME);
    }

    private static void assertContainsPlace(List<Place> places, String name) {
        for (Place place : places)
            if (place.getName().equals(name))
                return;
        fail("Place \"" + name + "\" not found!");
    }
}
