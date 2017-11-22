package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/19/2017.
 */
@Root(name = "tas1:column", strict = false)
public class TaskColumnNameRequest {
    @Element(name = "tas1:columnName", required = false)
    private String columnName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
