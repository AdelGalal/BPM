package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.ArrayList;

/**
 * Created by ADEL on 11/15/2017.
 */

@Root( strict = false)

public class TaskOptionalInfoRequest {
    @Path("tas1:taskOptionalInfo[1]")
    @Text
    private String taskFirstOptionalInfo;
    @Path("tas1:taskOptionalInfo[2]")
    @Text
    private String taskSecondOptionalInfo;

    public String getTaskFirstOptionalInfo() {
        return taskFirstOptionalInfo;
    }

    public void setTaskFirstOptionalInfo(String taskFirstOptionalInfo) {
        this.taskFirstOptionalInfo = taskFirstOptionalInfo;
    }

    public String getTaskSecondOptionalInfo() {
        return taskSecondOptionalInfo;
    }

    public void setTaskSecondOptionalInfo(String taskSecondOptionalInfo) {
        this.taskSecondOptionalInfo = taskSecondOptionalInfo;
    }

}
