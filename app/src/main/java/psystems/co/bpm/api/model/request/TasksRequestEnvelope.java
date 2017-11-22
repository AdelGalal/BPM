package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/13/2017.
 */

@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace( prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace( prefix = "tas", reference = "http://xmlns.oracle.com/bpel/workflow/taskQueryService"),
        @Namespace( prefix = "com", reference = "http://xmlns.oracle.com/bpel/workflow/common"),
        @Namespace( prefix = "tas1", reference = "http://xmlns.oracle.com/bpel/workflow/taskQuery"),
        @Namespace( prefix = "task", reference = "http://xmlns.oracle.com/bpel/workflow/task")

})
public class TasksRequestEnvelope {

    @Element(name = "soapenv:Body", required = false)
    private TaskRequestBody body;


    public TaskRequestBody getBody() {
        return body;
    }

    public void setBody(TaskRequestBody body) {
        this.body = body;
    }
}
