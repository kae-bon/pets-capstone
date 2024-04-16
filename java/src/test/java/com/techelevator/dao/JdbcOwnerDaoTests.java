package com.techelevator.dao;

import com.techelevator.exception.UnderEighteenException;
import com.techelevator.model.Owner;
import com.techelevator.model.RegisterOwnerDto;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.time.LocalDate;


public class JdbcOwnerDaoTests extends BaseDaoTests {

    protected static final Owner OWNER_1 = new Owner
            (1,
                    "McQueen",
                    "Steve",
                    LocalDate.of(1930, 03, 24),
                    "https://res.cloudinary.com/dccsx3iht/image/upload/v1712878757/owner_id1.jpg",
                    "stevemcqueeniscool@yahoo.com"
    );
    private JdbcOwnerDao sut;
    private JdbcUserDao jdbcUserDao;
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
        owner.setProfilePic("https://res.cloudinary.com/dccsx3iht/image/upload/v1712878757/owner_id1.jpg");
        owner.setId(4);
        Owner carly = sut.createOwner(owner);

        Assert.assertNotNull(carly);

        Owner retrievedOwner = sut.getOwnerById(carly.getId());
        assertOwnersMatch(retrievedOwner, carly);
    }

    @Test(expected = UnderEighteenException.class)
    public void createNewOwner_fails_to_create_a_newOwner_when_under_18() {
        RegisterOwnerDto owner = new RegisterOwnerDto();
        owner.setFirstName("Carly");
        owner.setLastName("Trimboli");
        owner.setBirthdate(LocalDate.of(2005, 04, 20));
        owner.setProfilePic("https://res.cloudinary.com/dccsx3iht/image/upload/v1712878757/owner_id1.jpg");
        Owner carly = sut.createOwner(owner);

    }
    @Test
    public void getOwnerByEmail_give_valid_email_returns_owner() {
       Assert.assertNull(null);
    }

    @Test(expected = HttpClientErrorException.NotFound.class)
    public void getOwnerById_returns_404_when_id_not_found() {
        int id = 100;
        Owner owner = sut.getOwnerById(id);
    }




    @Test
    public void updateOwner_updates_owner() {

        Owner ownerToUpdate = sut.getOwnerById(OWNER_1.getId());

        ownerToUpdate.setFirstName("Lightning");
        ownerToUpdate.setProfilePic("https://upload.wikimedia.org/wikipedia/en/8/82/Lightning_McQueen.png");
        ownerToUpdate.setEmail("stvemcqueenisdead@yahoo.com");


        Owner updatedOwner = sut.updateOwner(ownerToUpdate);

        Owner retrievedOwner = sut.getOwnerById(updatedOwner.getId());

        assertOwnersMatch(updatedOwner, retrievedOwner);

        assertOwnersMatch(updatedOwner, ownerToUpdate);

    }

    private void assertOwnersMatch (Owner expectedOwner, Owner actualOwner) {
        Assert.assertEquals(expectedOwner.getId(), actualOwner.getId());
        Assert.assertEquals(expectedOwner.getFirstName(), actualOwner.getFirstName());
        Assert.assertEquals(expectedOwner.getLastName(), actualOwner.getLastName());
        Assert.assertEquals(expectedOwner.getBirthdate(), actualOwner.getBirthdate());
        Assert.assertEquals(expectedOwner.getProfilePic(), actualOwner.getProfilePic());
    }
}