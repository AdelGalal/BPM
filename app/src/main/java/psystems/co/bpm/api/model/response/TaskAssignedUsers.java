package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/16/2017.
 */

@Root(name = "assigneeUsers")
public class TaskAssignedUsers {
    @Element(name = "id", required = false)
    private String id;

    @Element(name = "type", required = false)
    private String type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
