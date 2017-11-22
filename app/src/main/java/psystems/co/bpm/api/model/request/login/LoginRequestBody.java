package psystems.co.bpm.api.model.request.login;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/13/2017.
 */

@Root(name = "soapenv:Body", strict = false)
public class LoginRequestBody {

    @Element(name = "com:credential", required = false)
    private LoginRequestData loginRequestData;


    public LoginRequestData getLoginRequestData() {
        return loginRequestData;
    }

    public void setLoginRequestData(LoginRequestData loginRequestData) {
        this.loginRequestData = loginRequestData;
    }
}