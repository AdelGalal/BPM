package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/16/2017.
 */
@Root(name = "fromUser")

public class TaskFromUserResponse {
    @Element(name = "type", required = false)
    private String type;
}
