package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/15/2017.
 */

@Root(name = "soapenv:Body", strict = false)
public class TaskRequestBody {

    @Element(name = "tas:taskListRequest", required = false)
    private TaskListRequest taskListRequest;

    public TaskListRequest getTaskListRequest() {
        return taskListRequest;
    }

    public void setTaskListRequest(TaskListRequest taskListRequest) {
        this.taskListRequest = taskListRequest;
    }
}