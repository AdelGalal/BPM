package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;


/**
 * Created by ADEL on 11/16/2017.
 */

@Root(name = "env:Envelope")
@NamespaceList({
        @Namespace( prefix = "env", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
})
public class TaskResponseEnvelope {

    @Element(required = false, name = "Header")//required
    private String header;

    @Element(name = "Body", required = false)
    private TaskResponseBody body;

    public TaskResponseBody getBody() {
        return body;
    }

    public void setBody(TaskResponseBody body) {
        this.body = body;
    }
}
