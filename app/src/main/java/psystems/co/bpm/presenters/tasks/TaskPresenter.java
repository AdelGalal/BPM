package psystems.co.bpm.presenters.tasks;

/**
 * Created by ADEL on 11/15/2017.
 */

public interface TaskPresenter {
    void makeSearch(String token, String firstDisplayColumn,String secondDisplayColumn,String thirdDisplayColumn,
                    String fourthDisplayColumn,String fifthDisplayColumn,String sixthDisplayColumn,
                    String firstOptionalTask,String secondOptionalTask,
                    String assignmentFilter);

}
