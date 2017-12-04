/*
 * Copyright 2016. Alejandro Sánchez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package psystems.co.bpm.domain.threads;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import psystems.co.bpm.domain.interactors.Interactor;
import psystems.co.bpm.domain.interactors.tasks.TaskDetailsInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInteractor;


public class InteractorExecutorImpl implements InteractorExecutor{

    private static final int CORE_POOL_SIZE = 2;

    private static final int MAXIMUM_POOL_SIZE = 2;

    private static final long LIFE_TIME = 60;

    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private static final BlockingQueue QUEUE = new LinkedBlockingQueue();

    private ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public InteractorExecutorImpl() {

        threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                LIFE_TIME,
                TIME_UNIT,
                QUEUE
        );

    }

    @Override
    public void run(final Interactor interactor) {

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

                interactor.run();

            }
        });

    }

    @Override
    public void runSorting(final Interactor interactor) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

                interactor.runSorting();

            }
        });

    }


}
