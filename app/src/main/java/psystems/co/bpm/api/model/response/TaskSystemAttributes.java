package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by ADEL on 11/16/2017.
 */
@Root(name = "systemAttributes")
public class TaskSystemAttributes {

    @Element(name = "acquiredBy", required = false)
    private String acquiredBy;

    @Element(name = "approvers", required = false)
    private String approvers;

    @Element(name = "assignedDate", required = false)
    private String assignedDate;

    @Element(name = "assigneeUsers", required = false)
    private TaskAssignedUsers taskAssignedUsers;

    @Element(name = "createdDate", required = false)
    private String createdDate;

    @ElementList(name = "customActions",inline=true, required = false)
    private List<TaskCustomActionsResponse> taskCustomActionsResponse;

    @Element(name = "endDate", required = false)
    private String endDate;

    @Element(name = "digitalSignatureRequired", required = false)
    private String digitalSignatureRequired;

    @Element(name = "fromUser", required = false)
    private TaskFromUserResponse taskFromUserResponse;

    @Element(name = "isGroup", required = false)
    private String isGroup;


    @Element(name = "numberOfTimesModified", required = false)
    private String numberOfTimesModified;

    @Element(name = "outcome", required = false)
    private String outcome;

    @Element(name = "state", required = false)
    private String state;

    @Element(name = "substate", required = false)
    private String substate;

    @ElementList(name = "systemActions",inline=true, required = false)

    private List<TaskSystemActionsResponse> taskSystemActionsResponses;

    @Element(name = "action", required = false)
    private String action;

    @Element(name = "displayName", required = false)
    private String displayName;

    @Element(name = "taskId", required = false)
    private String taskId;

    @Element(name = "taskNumber", required = false)
    private String taskNumber;

    @Element(name = "updatedBy", required = false)
    private TaskUpdatedByResponse taskUpdatedByResponse;


    @Element(name = "updatedDate", required = false)
    private String updatedDate;

    @Element(name = "version", required = false)
    private String version;

    @Element(name = "taskDefinitionId", required = false)
    private String taskDefinitionId;

    @Element(name = "taskDefinitionName", required = false)
    private String taskDefinitionName;

    @Element(name = "workflowPattern", required = false)
    private String workflowPattern;

    @Element(name = "participantName", required = false)
    private String participantName;

    @Element(name = "reviewers", required = false)
    private TaskReviwersResponse taskReviwersResponse;


    @Element(name = "assignees", required = false)
    private TaskAssignees taskAssignees;

    @Element(name = "rootTaskId", required = false)
    private String rootTaskId;

    @Element(name = "isPartialTask", required = false)
    private String isPartialTask;

    @Element(name = "swimlaneRole", required = false)
    private String swimlaneRole;

    @Element(name = "isDecomposedTask", required = false)
    private String isDecomposedTask;

    @Element(name = "formName", required = false)
    private String formName;

    @Element(name = "hiddenAttributes", required = false)
    private String hiddenAttributes;

    @Element(name = "isCreatorHidden", required = false)
    private String isCreatorHidden;

    @Element(name = "creatorCustomText", required = false)
    private String creatorCustomText;

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public TaskAssignedUsers getTaskAssignedUsers() {
        return taskAssignedUsers;
    }

    public void setTaskAssignedUsers(TaskAssignedUsers taskAssignedUsers) {
        this.taskAssignedUsers = taskAssignedUsers;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTaskDefinitionId() {
        return taskDefinitionId;
    }

    public void setTaskDefinitionId(String taskDefinitionId) {
        this.taskDefinitionId = taskDefinitionId;
    }

    public String getWorkflowPattern() {
        return workflowPattern;
    }

    public void setWorkflowPattern(String workflowPattern) {
        this.workflowPattern = workflowPattern;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getIsPartialTask() {
        return isPartialTask;
    }

    public void setIsPartialTask(String isPartialTask) {
        this.isPartialTask = isPartialTask;
    }

    public String getIsDecomposedTask() {
        return isDecomposedTask;
    }

    public void setIsDecomposedTask(String isDecomposedTask) {
        this.isDecomposedTask = isDecomposedTask;
    }

    public String getSwimlaneRole() {
        return swimlaneRole;
    }

    public void setSwimlaneRole(String swimlaneRole) {
        this.swimlaneRole = swimlaneRole;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getDigitalSignatureRequired() {
        return digitalSignatureRequired;
    }

    public void setDigitalSignatureRequired(String digitalSignatureRequired) {
        this.digitalSignatureRequired = digitalSignatureRequired;
    }

    public String getApprovers() {
        return approvers;
    }

    public void setApprovers(String approvers) {
        this.approvers = approvers;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getAcquiredBy() {
        return acquiredBy;
    }

    public void setAcquiredBy(String acquiredBy) {
        this.acquiredBy = acquiredBy;
    }
}
