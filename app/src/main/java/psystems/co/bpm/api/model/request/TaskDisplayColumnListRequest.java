package psystems.co.bpm.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by ADEL on 11/15/2017.
 */

//@Element(name = "tas1:displayColumn")
@Root(strict = false)
public class TaskDisplayColumnListRequest {
    @Path("tas1:displayColumn[1]")
    @Text
    private String displayFirstColumn;
    @Path("tas1:displayColumn[2]")
    @Text
    private String displaySecondColumn;
    @Path("tas1:displayColumn[3]")
    @Text
    private String displayThirdColumn;
    @Path("tas1:displayColumn[4]")
    @Text
    private String displayFourthColumn;
    @Path("tas1:displayColumn[5]")
    @Text
    private String displayFifthColumn;
    @Path("tas1:displayColumn[6]")
    @Text
    private String displaySixthColumn;


    public String getDisplayFirstColumn() {
        return displayFirstColumn;
    }

    public void setDisplayFirstColumn(String displayFirstColumn) {
        this.displayFirstColumn = displayFirstColumn;
    }

    public String getDisplaySecondColumn() {
        return displaySecondColumn;
    }

    public void setDisplaySecondColumn(String displaySecondColumn) {
        this.displaySecondColumn = displaySecondColumn;
    }

    public String getDisplayThirdColumn() {
        return displayThirdColumn;
    }

    public void setDisplayThirdColumn(String displayThirdColumn) {
        this.displayThirdColumn = displayThirdColumn;
    }

    public String getDisplayFourthColumn() {
        return displayFourthColumn;
    }

    public void setDisplayFourthColumn(String displayFourthColumn) {
        this.displayFourthColumn = displayFourthColumn;
    }

    public String getDisplayFifthColumn() {
        return displayFifthColumn;
    }

    public void setDisplayFifthColumn(String displayFifthColumn) {
        this.displayFifthColumn = displayFifthColumn;
    }

    public String getDisplaySixthColumn() {
        return displaySixthColumn;
    }

    public void setDisplaySixthColumn(String displaySixthColumn) {
        this.displaySixthColumn = displaySixthColumn;
    }
}
