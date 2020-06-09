package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;

@Slf4j
public class PullRequestRequests extends AbstractRequests {

    public void getAllPRRequest(String token, int responseCode) {
        Response response = getRequests.withToken(token, responseCode, Resources.getPullRequests());
        log.info(response.asString());
    }
}
