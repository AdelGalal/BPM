package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by ADEL on 11/20/2017.
 */
@Root( name = "systemActions",strict = false)
public class TaskSystemActionsResponse {
    @Path("action")
    @Text(required=false)
    private String action;

    @Path("displayName")
    @Text(required=false)
    private String displayName;
}
