package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;

@Slf4j
public class ProjectRequests extends AbstractRequests {

    public void createProject(String token, String body, int responseCode) {
        Response response = postRequests.withToken(token, body, responseCode, Resources.getProjects());
        log.info(response.asString());
//        log.info();
    }
}
