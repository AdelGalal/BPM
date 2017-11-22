package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/19/2017.
 */
@Root(name = "processInfo")
public class TaskProcessInfoResponse {
    @Element(name = "instanceId", required = false)
    private String instanceId;

    @Element(name = "processId", required = false)
    private String processId;

    @Element(name = "processName", required = false)
    private String processName;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
