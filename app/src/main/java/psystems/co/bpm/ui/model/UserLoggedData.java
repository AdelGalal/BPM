package psystems.co.bpm.ui.model;

import java.io.Serializable;

/**
 * Created by ADEL on 11/27/2017.
 */

public class UserLoggedData implements Serializable {
    public static final String EXTRA = "psystems.co.bpm.ui.model.USER_EXTRA";
    private String userName;
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
