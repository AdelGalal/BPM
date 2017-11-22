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


import dagger.Component;
import psystems.co.bpm.api.model.response.TableElement;
import psystems.co.bpm.domain.interactors.login.LoginInteractor;
import psystems.co.bpm.domain.model.ZipCodeDomain;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.injection.application.ApplicationComponent;
import psystems.co.bpm.presenters.ZipCodesPresenter;
import psystems.co.bpm.ui.activities.LoginActivity;
import psystems.co.bpm.ui.model.ZipCodeData;
import psystems.co.bpm.util.EntityMapper;


@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = ZipCodeModule.class
)
public interface ZipCodeComponent {

    void inject(LoginActivity activity);

    RecyclerView.Adapter providesZipCodesAdapter();

    ZipCodesPresenter providesPresenter();

    EntityMapper<ZipCodeData,ZipCodeDomain> providesUiMapper();

    EntityMapper<ZipCodeDomain,TableElement> providesDomainMapper();

    LoginInteractor providesInteractor();

    InteractorExecutor providesInteractorExecutor();

    MainThread providesMainThread();

}
