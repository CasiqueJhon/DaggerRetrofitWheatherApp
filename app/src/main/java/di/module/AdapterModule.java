package di.module;

import com.jhonisaac.daggerretrofitwheatherapp.TimeAdapter;

import dagger.Module;
import dagger.Provides;
import di.scope.ApplicationScope;

@Module
public class AdapterModule {

    @ApplicationScope
    @Provides
    public TimeAdapter getTimeAdapter() {
        return new TimeAdapter();
    }

}
