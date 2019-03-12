package di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import di.scope.ApplicationScope;

@Module
public class ApplicationContextModule {

    private Application application;

    public ApplicationContextModule (Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    public Application provideApplication() {

        return application;
    }

    @Provides
    @ApplicationScope
    public Context provideApplicationContext(){

        return application.getApplicationContext();
    }

}
