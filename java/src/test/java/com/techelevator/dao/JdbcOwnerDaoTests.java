package com.techelevator.dao;

import com.techelevator.model.Owner;
import com.techelevator.model.RegisterOwnerDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;


public class JdbcOwnerDaoTests extends BaseDaoTests {

    protected static final Owner OWNER_1 = new Owner
            (1,
                    "stevemcqueeniscool@yahoo.com",
                    "McQueen",
                    "Steve",
                    LocalDate.of(1930, 03, 24)
    );
    private JdbcOwnerDao sut;
    @Before
   public void setUp() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcOwnerDao(jdbcTemplate);
    }

    @Test
    public void getOwnerById_give_valid_owner_id_returns_owner() {

        Owner actualOwner = sut.getOwnerById(OWNER_1.getId());

        Assert.assertEquals(OWNER_1.getId(), actualOwner.getId());
    }

    @Test
    public void createNewOwner_creates_a_newOwner() {
        RegisterOwnerDto owner = new RegisterOwnerDto();
        owner.setFirstName("Carly");
        owner.setLastName("Trimboli");
        owner.setBirthdate(LocalDate.of(1985, 04, 20));
        owner.setEmail("carlyiscool@gmail.com");
        Owner carly = sut.createOwner(owner);

        Assert.assertNotNull(carly);

        Owner retrievedOwner = sut.getOwnerById(carly.getId());
        assertOwnersMatch(retrievedOwner, carly);
    }
    @Test
    public void getOwnerByEmail_give_valid_email_returns_owner() {
        Owner actualOwner = sut.getOwnerByEmail(OWNER_1.getEmail());
        Assert.assertEquals(OWNER_1.getId(), actualOwner.getId());
    }


    private void assertOwnersMatch (Owner expectedOwner, Owner actualOwner) {
        Assert.assertEquals(expectedOwner.getId(), actualOwner.getId());
        Assert.assertEquals(expectedOwner.getFirstName(), actualOwner.getFirstName());
        Assert.assertEquals(expectedOwner.getLastName(), actualOwner.getLastName());
        Assert.assertEquals(expectedOwner.getBirthdate(), actualOwner.getBirthdate());
        Assert.assertEquals(expectedOwner.getEmail(), actualOwner.getEmail());
    }

}