package psystems.co.bpm.domain.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import psystems.co.bpm.domain.interactors.tasks.TaskDetailsInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateInteractor;

/**
 * Created by ADEL on 12/6/2017.
 */

public class InteractorExecutorOfInitiateTasksImpl  implements InteractorExecutorOfInitiateTasks {
    private static final int CORE_POOL_SIZE = 2;

    private static final int MAXIMUM_POOL_SIZE = 2;

    private static final long LIFE_TIME = 60;

    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private static final BlockingQueue QUEUE = new LinkedBlockingQueue();

    private ThreadPoolExecutor threadPoolExecutor;
    @Inject
    public InteractorExecutorOfInitiateTasksImpl() {

        threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                LIFE_TIME,
                TIME_UNIT,
                QUEUE
        );

    }

    @Override
    public void run(final TaskInitiateInteractor interactor) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

                interactor.runInitiateTask();

            }
        });
    }
}
