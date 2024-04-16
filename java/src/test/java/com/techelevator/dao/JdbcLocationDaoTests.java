package com.techelevator.dao;

import com.techelevator.model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcLocationDaoTests extends BaseDaoTests {
    private JdbcLocationDao sut;
    private final Location PARK_ONE = new Location(1, "Otto Armleder Dog Park",
            "5057 Wooster Pike", "Cincinnati", "OH");
    private final Location PARK_TWO = new Location(2, "Fido Field", "630 Eggleston Ave", "Cincinnati", "OH");

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcLocationDao(jdbcTemplate);
    }

    @Test
    public void getAllLocations() {
        List<Location> locations = sut.getAllLocations();

        Assert.assertNotNull(locations);
        assertLocationsMatch(PARK_ONE, locations.get(1));
        assertLocationsMatch(PARK_TWO, locations.get(0));
    }

    private void assertLocationsMatch(Location actual, Location expected) {
        Assert.assertEquals(actual.getId(), expected.getId());
        Assert.assertTrue(actual.getName().equals(expected.getName()));
        Assert.assertTrue(actual.getCity().equals(expected.getCity()));
        Assert.assertTrue(actual.getStateAbbreviation().equals(expected.getStateAbbreviation()));
        Assert.assertTrue(actual.getStreetAddress().equals(expected.getStreetAddress()));
    }
}
