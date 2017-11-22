package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by ADEL on 11/20/2017.
 */
@Root( name = "customActions",strict = false)
public class TaskCustomActionsResponse {

    @Path("action")
    @Text(required=false)
    private String action;

    @Path("displayName")
    @Text(required=false)
    private String displayName;

}
