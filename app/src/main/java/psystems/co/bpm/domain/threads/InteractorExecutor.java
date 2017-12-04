
package psystems.co.bpm.domain.threads;

import psystems.co.bpm.domain.interactors.Interactor;

public interface InteractorExecutor {

    void run(Interactor interactor);
    void runSorting(Interactor interactor);

}
