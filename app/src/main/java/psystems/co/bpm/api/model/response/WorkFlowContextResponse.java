package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/14/2017.
 */

@Root(name = "workflowContext", strict = false)
@Namespace(reference = "http://xmlns.oracle.com/bpel/workflow/common")
public class WorkFlowContextResponse {
    @Element(name = "credential", required = false)
    private CredentialOfLoginResponse credentialcOfLoginResponse;

    @Element(name = "token", required = false)
    private String token;

    @Element(name = "locale", required = false)
    private String locale;

    @Element(name = "userDisplayName", required = false)
    private String userDisplayName;

    @Element(name = "isAdmin", required = false)
    private String isAdmin;

    @Element(name = "isBusinessAdmin", required = false)
    private String isBusinessAdmin;

    @Element(name = "isManager", required = false)
    private String isManager;

    @Element(name = "type", required = false)
    private String type;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsBusinessAdmin() {
        return isBusinessAdmin;
    }

    public void setIsBusinessAdmin(String isBusinessAdmin) {
        this.isBusinessAdmin = isBusinessAdmin;
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CredentialOfLoginResponse getCredentialcOfLoginResponse() {
        return credentialcOfLoginResponse;
    }

    public void setCredentialcOfLoginResponse(CredentialOfLoginResponse credentialcOfLoginResponse) {
        this.credentialcOfLoginResponse = credentialcOfLoginResponse;
    }

}
