package org.academy.api.requests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;
import org.academy.api.pojo.forks.Fork;

import java.util.ArrayList;


@Slf4j
public class ForkedUsersRequests extends AbstractRequests {

    @SneakyThrows
    public void getAllUsers(String token, int responseCode) {
        Response response = getRequests.withToken(token, responseCode, Resources.getForks());
        log.info(response.asString());
        String userNames = response.jsonPath().setRootPath("owner").getString("login");
        log.info(userNames);

        ////

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.asString());

        ArrayList<String> users = new ArrayList<>();
        if (jsonNode.isArray()) {
            for (JsonNode node : jsonNode) {
                String nodeContent = mapper.writeValueAsString(node);
                Fork fork = mapper.readValue(nodeContent, Fork.class);
                users.add(fork.owner.login);
            }
        }
//        if (jsonNode.isArray()) {
//            for (JsonNode node : jsonNode) {
//                Fork fork = mapper.convertValue(node, Fork.class);
//                users.add(fork.owner.login);
//            }
//        }
        log.info(String.valueOf(users));

    }
}
