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

package psystems.co.bpm.injection.zip;

import android.support.v7.widget.RecyclerView;


import dagger.Module;
import dagger.Provides;
import psystems.co.bpm.api.model.response.TableElement;
import psystems.co.bpm.domain.interactors.login.LoginInteractor;
import psystems.co.bpm.domain.interactors.login.LoginInteractorImpl;
import psystems.co.bpm.domain.model.ZipCodeDomain;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.InteractorExecutorImpl;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.domain.threads.MainThreadImpl;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.presenters.ZipCodesPresenter;
import psystems.co.bpm.presenters.ZipCodesPresenterImpl;
import psystems.co.bpm.ui.activities.LoginActivity;
import psystems.co.bpm.ui.adapter.ZipCodesAdapter;
import psystems.co.bpm.ui.model.ZipCodeData;
import psystems.co.bpm.ui.views.LoginZipsView;
import psystems.co.bpm.util.EntityMapper;
import psystems.co.bpm.util.ZipCodeMapperDomain;
import psystems.co.bpm.util.ZipCodeMapperUi;


@Module
public class ZipCodeModule {

    private LoginActivity activity;


    public ZipCodeModule(LoginActivity activity) {
        this.activity = activity;
    }


    @Provides
    @ActivityScope
    public LoginZipsView providesView(){
        return activity;
    }

    @Provides
    @ActivityScope
    public ZipCodesPresenter providesPresenter(ZipCodesPresenterImpl zipCodesPresenter){
        return zipCodesPresenter;
    }

    @Provides
    @ActivityScope
    public EntityMapper<ZipCodeData,ZipCodeDomain> providesMapper(ZipCodeMapperUi mapper){
        return  mapper;
    }

    @Provides
    @ActivityScope
    public EntityMapper<ZipCodeDomain,TableElement> providesDomainMapper(ZipCodeMapperDomain mapper){
        return  mapper;
    }



    @Provides
    @ActivityScope
    public LoginInteractor providesInteractor(LoginInteractorImpl interactor){
        return interactor;
    }

    @Provides
    @ActivityScope
    public RecyclerView.Adapter providesAdapter(ZipCodesAdapter adapter){
        return adapter;
    }


    @Provides
    @ActivityScope
    public InteractorExecutor providesInteractorExecutor(InteractorExecutorImpl interactorExecutor){
        return interactorExecutor;
    }

    @Provides
    @ActivityScope
    public MainThread providesMainThread(MainThreadImpl mainThread){
        return mainThread;
    }
}
