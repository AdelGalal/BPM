package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/16/2017.
 */
@Root(name = "task", strict = false)

public class TaskElement {
    @Element(name = "title", required = false)
    private String title;

    @Element(name = "creator", required = false)
    private String creator;

    @Element(name = "ownerRole", required = false)
    private String ownerRole;

    @Element(name = "priority", required = false)
    private String priority;

    @Element(name = "userComment", required = false)
    private TaskUserCommentResponse taskUserCommentResponse;

    @Element(name = "processInfo", required = false)
    private TaskProcessInfoResponse taskProcessInfoResponse;

    @Element(name = "systemAttributes", required = false)
    private TaskSystemAttributes taskSystemAttributes;


    @Element(name = "systemMessageAttributes", required = false)
    private String systemMessageAttributes;

    @Element(name = "callback", required = false)
    private String callback;

    @Element(name = "sca", required = false)
    private String sca;

    @Element(name = "compositeDN", required = false)
    private String sca_compositeDN;

    @Element(name = "applicationContext", required = false)
    private String applicationContext;

    @Element(name = "taskDefinitionId", required = false)
    private String taskDefinitionId;

    @Element(name = "mdsLabel", required = false)
    private String mdsLabel;

    @Element(name = "customAttributes", required = false)
    private String customAttributes;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOwnerRole() {
        return ownerRole;
    }

    public void setOwnerRole(String ownerRole) {
        this.ownerRole = ownerRole;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public TaskSystemAttributes getTaskSystemAttributes() {
        return taskSystemAttributes;
    }

    public void setTaskSystemAttributes(TaskSystemAttributes taskSystemAttributes) {
        this.taskSystemAttributes = taskSystemAttributes;
    }

    public TaskProcessInfoResponse getTaskProcessInfoResponse() {
        return taskProcessInfoResponse;
    }

    public void setTaskProcessInfoResponse(TaskProcessInfoResponse taskProcessInfoResponse) {
        this.taskProcessInfoResponse = taskProcessInfoResponse;
    }

    public TaskUserCommentResponse getTaskUserCommentResponse() {
        return taskUserCommentResponse;
    }

    public void setTaskUserCommentResponse(TaskUserCommentResponse taskUserCommentResponse) {
        this.taskUserCommentResponse = taskUserCommentResponse;
    }
}
