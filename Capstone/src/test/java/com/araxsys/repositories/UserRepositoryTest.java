package com.araxsys.repositories;

import com.araxsys.config.RepositoryConfiguration;
import com.araxsys.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class UserRepositoryTest {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testSaveUser(){
        //setup user
        User user = new User();
        user.setPassword("Spring");
        user.setUsername("1234");

        //save user, verify has ID value after save
        //assertNull(user.getUsername()); //null before save
        userRepository.save(user);
        assertNotNull(user.getUsername()); //not null after save

        //fetch from DB
        User fetchedUser = userRepository.findOne(user.getUsername());

        //should not be null
        assertNotNull(fetchedUser);

        //should equal
        assertEquals(user.getUsername(), fetchedUser.getUsername());
        assertEquals(user.getPassword(), fetchedUser.getPassword());

        //update description and save
        fetchedUser.setPassword("New Description");
        userRepository.save(fetchedUser);

        //get from DB, should be updated
        User fetchedUpdatedUser = userRepository.findOne(fetchedUser.getUsername());
        assertEquals(fetchedUser.getPassword(), fetchedUpdatedUser.getPassword());

        //verify count of users in DB
        long userCount = userRepository.count();
        assertEquals(userCount, 1);

        //get all users, list should only have one
        Iterable<User> users = userRepository.findAll();

        int count = 0;

        for(User p : users){
            count++;
        }

        assertEquals(count, 1);
    }
}
