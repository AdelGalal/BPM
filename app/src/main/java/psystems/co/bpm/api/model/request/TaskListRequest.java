package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/15/2017.
 */

@Root(name = "tas:taskListRequest", strict = false)
public class TaskListRequest {
    @Element(name = "com:workflowContext", required = false)
    private TaskWorkFlowContextRequest taskWorkFlowContextRequest;

    @Element(name = "tas1:taskPredicateQuery", required = false)
    private TaskPredicateQueryRequest taskPredicateQueryRequest;


    public TaskWorkFlowContextRequest getTaskWorkFlowContextRequest() {
        return taskWorkFlowContextRequest;
    }

    public void setTaskWorkFlowContextRequest(TaskWorkFlowContextRequest taskWorkFlowContextRequest) {
        this.taskWorkFlowContextRequest = taskWorkFlowContextRequest;
    }

    public TaskPredicateQueryRequest getTaskPredicateQueryRequest() {
        return taskPredicateQueryRequest;
    }

    public void setTaskPredicateQueryRequest(TaskPredicateQueryRequest taskPredicateQueryRequest) {
        this.taskPredicateQueryRequest = taskPredicateQueryRequest;
    }

}
