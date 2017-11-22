package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/19/2017.
 */
@Root(name = "userComment")
public class TaskUserCommentResponse {
    @Element(name = "comment", required = false)
    private String comment;

    @Element(name = "updatedBy", required = false)
    private TaskUpdatedByResponse  taskUpdatedByResponse;

    @Element(name = "updatedDate", required = false)
    private String updatedDate;

    @Element(name = "taskId", required = false)
    private String taskId;

    @Element(name = "commentScope", required = false)
    private String commentScope;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
