package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/14/2017.
 */

@Root(name = "credential", strict = false)
public class CredentialOfLoginResponse {
    @Element(name = "login", required = false)
    private String login;

    @Element(name = "identityContext", required = false)
    private String identityContext;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdentityContext() {
        return identityContext;
    }

    public void setIdentityContext(String identityContext) {
        this.identityContext = identityContext;
    }
}
