package psystems.co.bpm.api.model.request.login;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/13/2017.
 */
@Root(name = "com:credential", strict = false)
public class LoginRequestData {
    @Element(name = "com:login", required = false)
    private String userName;

    @Element(name = "com:password", required = false)

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
