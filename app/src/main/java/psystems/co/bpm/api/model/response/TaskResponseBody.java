package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.ArrayList;


/**
 * Created by ADEL on 11/16/2017.
 */
@Root(name = "Body", strict = false)
public class TaskResponseBody {

    @ElementList(name = "taskListResponse", required = false)
    private ArrayList<TaskElement>taskElements;


    public ArrayList<TaskElement> getTaskElements() {
        return taskElements;
    }

    public void setTaskElements(ArrayList<TaskElement> taskElements) {
        this.taskElements = taskElements;
    }
}
