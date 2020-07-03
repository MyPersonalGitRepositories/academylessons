package org.academy.api.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CasesResultPOJO {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("content", "Some content 1");
        map1.put("status_id", "1");
        map1.put("expected", "exp1");
        map1.put("actual", "actual1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("content", "Some content 2");
        map2.put("status_id", "2");
        map2.put("expected", "exp2");
        map2.put("actual", "actual2");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        Map<String, List<Map<String, String>>> stepResults = new HashMap<>();
        stepResults.put("1111", list);

        String jsonBody = new Gson().toJson(CasesResultPOJO.getPOJO(stepResults));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(jsonBody));
    }

    private static RailStepResults getPOJO(Map<String, List<Map<String, String>>> caseStatusMap) {
        List<Result> resultList = new ArrayList<>();
        for (String caseId : caseStatusMap.keySet()) {
            List<CustomStepResult> casesResultsList = new ArrayList<>();
            Result result = new Result();
            try {
                for (Map<String, String> stepRes : caseStatusMap.get(caseId)) {
                    CustomStepResult customStepResult = new CustomStepResult();
                    customStepResult.setContent(stepRes.get("content"));
                    customStepResult.setStatusId(Integer.parseInt(stepRes.get("status_id")));
                    customStepResult.setExpected(stepRes.get("expected"));
                    customStepResult.setActual(stepRes.get("actual"));
                    casesResultsList.add(customStepResult);
                }
                result.setCaseId(Integer.parseInt(caseId));
                result.setStatusId(Integer.parseInt(caseStatusMap.get(caseId).get(caseStatusMap.get(caseId).size() - 1).get("status_id")));
            } catch (ArrayIndexOutOfBoundsException e) {
                log.error("::Test Rail:: Case result list is empty".concat(e.getMessage()));
                throw new ArrayIndexOutOfBoundsException();
            }

            // Optional :: add functionality for additional parameters to test case result
            result.setComment("");
            result.setElapsed("");
            result.setDefects("");
            result.setVersion("");
            result.setCustomStepResults(casesResultsList);
            resultList.add(result);
        }

        RailStepResults casesResults = new RailStepResults();
        casesResults.setResults(resultList);
        return casesResults;
    }
}
