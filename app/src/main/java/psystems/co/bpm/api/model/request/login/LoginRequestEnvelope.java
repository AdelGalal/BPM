package psystems.co.bpm.api.model.request.login;

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
        @Namespace( prefix = "com", reference = "http://xmlns.oracle.com/bpel/workflow/common"),
})
public class LoginRequestEnvelope {

    @Element(name = "soapenv:Body", required = false)
    private LoginRequestBody body;


    public LoginRequestBody getBody() {
        return body;
    }

    public void setBody(LoginRequestBody body) {
        this.body = body;
    }
}
