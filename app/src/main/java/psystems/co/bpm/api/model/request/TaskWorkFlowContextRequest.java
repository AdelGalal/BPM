package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/15/2017.
 */

@Root(name = "com:workflowContext", strict = false)
public class TaskWorkFlowContextRequest {

    @Element(name = "com:token", required = false)
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

