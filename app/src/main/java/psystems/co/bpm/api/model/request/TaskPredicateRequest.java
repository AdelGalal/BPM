package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/15/2017.
 */

@Root(name = "tas1:predicate", strict = false)
public class TaskPredicateRequest {

    @Element(name = "tas1:assignmentFilter", required = false)
    private String assignmentFilter;

    @Element(name = "tas1:clause", required = false)
    private TaskClauseRequest taskClauseRequest;

    public String getAssignmentFilter() {
        return assignmentFilter;
    }

    public void setAssignmentFilter(String assignmentFilter) {
        this.assignmentFilter = assignmentFilter;
    }

    public TaskClauseRequest getTaskClauseRequest() {
        return taskClauseRequest;
    }

    public void setTaskClauseRequest(TaskClauseRequest taskClauseRequest) {
        this.taskClauseRequest = taskClauseRequest;
    }
}
