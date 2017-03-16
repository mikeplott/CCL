package com.CCL.entitytests;

import com.CCL.entities.api_access.User;
import com.CCL.services.UserRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Mike on 1/18/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityTests {

    @Autowired
    private UserRepo users;

    @Test
    public void getUserFromDBTest() {
        User user = users.findOne(1);
        Assert.assertTrue(user != null);
    }
}
