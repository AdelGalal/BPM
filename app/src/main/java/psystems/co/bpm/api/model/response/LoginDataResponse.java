package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/14/2017.
 */

@Root(name = "Body", strict = false)

public class LoginDataResponse {

    @Element(name = "workflowContext", required = false)
    private WorkFlowContextResponse workFlowContextResponse;


    public WorkFlowContextResponse getWorkFlowContextResponse() {
        return workFlowContextResponse;
    }

    public void setWorkFlowContextResponse(WorkFlowContextResponse workFlowContextResponse) {
        this.workFlowContextResponse = workFlowContextResponse;
    }
}
