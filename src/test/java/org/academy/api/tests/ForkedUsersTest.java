package org.academy.api.tests;

import org.academy.TestConfigurations;
import org.academy.api.requests.ForkedUsersRequests;
import org.testng.annotations.Test;

public class ForkedUsersTest {
    private ForkedUsersRequests forkedUsersRequests = new ForkedUsersRequests();

    @Test
    public void getAllForkedUsers() {
        forkedUsersRequests.getAllUsers(TestConfigurations.getApiToken(), 200);
    }
}
