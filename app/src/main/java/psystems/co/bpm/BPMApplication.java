package psystems.co.bpm;

import android.app.Application;

import psystems.co.bpm.injection.application.ApplicationComponent;
import psystems.co.bpm.injection.application.ApplicationModule;
import psystems.co.bpm.injection.application.DaggerApplicationComponent;

/**
 * Created by ADEL on 11/14/2017.
 */

public class BPMApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component =  DaggerApplicationComponent.builder()
                .applicationModule( new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
