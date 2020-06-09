package org.academy.api.tests;

import org.academy.TestConfigurations;
import org.academy.api.requests.PullRequestRequests;
import org.testng.annotations.Test;

public class PullRequestTests {
    private PullRequestRequests pullRequestRequests = new PullRequestRequests();

    @Test
    public void getAllPullRequests() {
        pullRequestRequests.getAllPRRequest(TestConfigurations.getApiToken(), 200);
    }
}
