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

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import psystems.co.bpm.BPMApplication;
import psystems.co.bpm.api.JsonClientApi;
import psystems.co.bpm.api.UsStatesApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
@Singleton
public class ApplicationModule {

    private BPMApplication application;
    private static final String base_URL = "http://192.168.1.215:8001/";

    public ApplicationModule(BPMApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public UsStatesApi providesApi(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Strategy strategy = new AnnotationStrategy();

        Serializer serializer = new Persister(strategy);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit =  new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .baseUrl(base_URL)
                .client(okHttpClient)
                .build();

        return retrofit.create( UsStatesApi.class);

    }

    @Provides
    @Singleton

    public JsonClientApi providesJsonApi(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .connectTimeout(2, TimeUnit.MINUTES)
//                .writeTimeout(2, TimeUnit.MINUTES)
//                .readTimeout(2, TimeUnit.MINUTES)
//                .build();

        Retrofit retrofit =  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_URL)

                .build();

        return retrofit.create( JsonClientApi.class);

    }
}
