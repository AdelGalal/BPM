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

package psystems.co.bpm.injection.application;

import javax.inject.Singleton;

import dagger.Component;
import psystems.co.bpm.api.JsonClientApi;
import psystems.co.bpm.api.UsStatesApi;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    UsStatesApi providesApi();
    JsonClientApi providesJsonApi();
}
