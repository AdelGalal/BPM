package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by ADEL on 11/15/2017.
 */

@Root(name = "tas1:taskPredicateQuery", strict = false)
public class TaskPredicateQueryRequest {

    @Element(name = "tas1:displayColumnList", required = false)

    private TaskDisplayColumnListRequest taskDisplayColumn;

    @Element(name = "tas1:optionalInfoList", required = false)
    private TaskOptionalInfoRequest taskOptionalInfo;


    @Element(name = "tas1:predicate", required = false)
    private TaskPredicateRequest taskPredicateRequest;



    public TaskPredicateRequest getTaskPredicateRequest() {
        return taskPredicateRequest;
    }

    public void setTaskPredicateRequest(TaskPredicateRequest taskPredicateRequest) {
        this.taskPredicateRequest = taskPredicateRequest;
    }


    public TaskDisplayColumnListRequest getTaskDisplayColumn() {
        return taskDisplayColumn;
    }

    public void setTaskDisplayColumn(TaskDisplayColumnListRequest taskDisplayColumn) {
        this.taskDisplayColumn = taskDisplayColumn;
    }

    public TaskOptionalInfoRequest getTaskOptionalInfo() {
        return taskOptionalInfo;
    }

    public void setTaskOptionalInfo(TaskOptionalInfoRequest taskOptionalInfo) {
        this.taskOptionalInfo = taskOptionalInfo;
    }
}
