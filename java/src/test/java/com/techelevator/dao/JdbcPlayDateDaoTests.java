package com.techelevator.dao;

import com.techelevator.model.PlayDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public class JdbcPlayDateDaoTests extends BaseDaoTests {
    private JdbcPlayDateDao sut;
    private final PlayDate PLAY_DATE_ONE = new PlayDate(1, "Test", "Testy Tests", 1, LocalDateTime.of(2024, 5, 2, 14, 30, 00),
            "Grant Park", true);
    private final PlayDate PLAY_DATE_TWO = new PlayDate(2, "Luna", "With Luna", 1, LocalDateTime.of(2024, 4, 15, 12, 00, 00),
            "Washington Park", false);

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPlayDateDao(jdbcTemplate);
    }

    @Test
    public void get_PlayDate_By_Id() {
        PlayDate playDate = sut.getPlayDateById(1);
        assertPlayDatesMatch(PLAY_DATE_ONE, playDate);

        playDate = sut.getPlayDateById(2);
        assertPlayDatesMatch(PLAY_DATE_TWO, playDate);
    }

    @Test
    public void create_PlayDate_Creates_PlayDate() {
        PlayDate newPlayDate = new PlayDate(0, "Marley", "With Marley", 1, LocalDateTime.of(2024, 4, 15, 12, 00, 00),
                "Loveland", true);

        PlayDate createdPlayDate = sut.createPlayDate(newPlayDate);
        int newId = createdPlayDate.getPlayDateId();
        System.out.println(newId);
        Assert.assertTrue(newId > 0);

        PlayDate retrievedPlayDate = sut.getPlayDateById(newId);
        assertPlayDatesMatch(createdPlayDate, retrievedPlayDate);
    }

    private void assertPlayDatesMatch(PlayDate expected, PlayDate actual) {
        Assert.assertEquals(expected.getPlayDateId(), actual.getPlayDateId());
        Assert.assertEquals(expected.getTitle(), actual.getTitle());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getHostId(), actual.getHostId());
        Assert.assertEquals(expected.getDateTime(), actual.getDateTime());
        Assert.assertEquals(expected.getLocation(), actual.getLocation());
        Assert.assertEquals(expected.isPublic(), actual.isPublic());
    }
}
