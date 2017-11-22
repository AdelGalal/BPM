package psystems.co.bpm.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ADEL on 11/16/2017.
 */

@Root(name = "reviewers")
public class TaskReviwersResponse {

    @Element(name = "id", required = false)
    private String id;

    @Element(name = "displayName", required = false)
    private String displayName;

    @Element(name = "type", required = false)
    private String type;
}
