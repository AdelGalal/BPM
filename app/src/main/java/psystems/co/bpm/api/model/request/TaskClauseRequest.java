package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/19/2017.
 */

@Root(name = "tas1:clause", strict = false)
public class TaskClauseRequest {
    @Element(name = "tas1:column tableName=\"WFTask\"", required = false)
    private String tableName;
   @Element(name = "tas1:column", required = false)
//    private String columnName;
    private TaskColumnNameRequest taskColumnNameRequest;

    @Element(name = "tas1:operator", required = false)
    private String taskOperatorRequest;

    @Element(name = "tas1:valueList", required = false)
    private TaskValuesList taskValuesList;

    public TaskColumnNameRequest getTaskColumnNameRequest() {
        return taskColumnNameRequest;
    }

    public void setTaskColumnNameRequest(TaskColumnNameRequest taskColumnNameRequest) {
        this.taskColumnNameRequest = taskColumnNameRequest;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTaskOperatorRequest() {
        return taskOperatorRequest;
    }

    public void setTaskOperatorRequest(String taskOperatorRequest) {
        this.taskOperatorRequest = taskOperatorRequest;
    }

    public TaskValuesList getTaskValuesList() {
        return taskValuesList;
    }

    public void setTaskValuesList(TaskValuesList taskValuesList) {
        this.taskValuesList = taskValuesList;
    }

//    public String getColumnName() {
//        return columnName;
//    }
//
//    public void setColumnName(String columnName) {
//        this.columnName = columnName;
//    }
}
