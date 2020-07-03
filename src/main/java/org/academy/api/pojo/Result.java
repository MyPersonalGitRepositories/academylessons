
package org.academy.api.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {

    @SerializedName("case_id")
    @Expose
    private Integer caseId;
    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("elapsed")
    @Expose
    private String elapsed;
    @SerializedName("defects")
    @Expose
    private String defects;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("custom_step_results")
    @Expose
    private List<CustomStepResult> customStepResults = new ArrayList<CustomStepResult>();

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public String getDefects() {
        return defects;
    }

    public void setDefects(String defects) {
        this.defects = defects;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<CustomStepResult> getCustomStepResults() {
        return customStepResults;
    }

    public void setCustomStepResults(List<CustomStepResult> customStepResults) {
        this.customStepResults = customStepResults;
    }

}
