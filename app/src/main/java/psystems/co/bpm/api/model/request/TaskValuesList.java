package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by ADEL on 11/19/2017.
 */

@Root(strict = false)
public class TaskValuesList {
    @Path("tas1:value[1]")
    @Text
    private String firstValue;
    @Path("tas1:value[2]")
    @Text
    private String secondValue;
    @Path("tas1:value[3]")
    @Text
    private String thirdValue;

    public String getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public String getThirdValue() {
        return thirdValue;
    }

    public void setThirdValue(String thirdValue) {
        this.thirdValue = thirdValue;
    }
}
