package psystems.co.bpm.domain.interactors.tasks;

import java.util.ArrayList;

import psystems.co.bpm.api.model.response.LoginDataResponse;
import psystems.co.bpm.api.model.response.TaskElement;
import psystems.co.bpm.api.model.response.TaskListResponse;
import psystems.co.bpm.api.model.response.TasksEntityResponse;
import psystems.co.bpm.domain.interactors.Interactor;
import psystems.co.bpm.domain.interactors.login.LoginInteractor;

/**
 * Created by ADEL on 11/15/2017.
 */

public interface TaskInteractor extends Interactor {

    interface Callback {

        void onSucess(TaskListResponse taskListResponse);

        void onError();

    }

    void execute(String token, String displayFirstColumn,String displaySecondColumn,String displayThirdColumn,String displayFourthColumn,
                 String displayFifthColumn,String displaySixthColumn,
                 String taskFirstOptionalInfo,String taskSecondOptionalInfo,
                 String assignmentFilter,Callback callback);

    void excuteSortingSearch(String token,String orderColumn,String order,String fromDate,String toDate,
                             String filter,String state,String keywords,String severity,Callback callback);

}