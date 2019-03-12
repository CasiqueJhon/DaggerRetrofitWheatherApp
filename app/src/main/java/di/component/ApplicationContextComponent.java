package di.component;

import dagger.Component;
import di.module.AdapterModule;
import di.module.ApplicationContextModule;
import di.module.RetrofitModule;
import di.scope.ApplicationScope;

@ApplicationScope
@Component(modules = {ApplicationContextModule.class, AdapterModule.class})
public interface ApplicationContextComponent {

    //Context context();

    //void inject (MainActivity mainActivity);



    //SharedPreferencesSubComponent plusSharedPreferencesSubComponent(SharedPreferencesModule sharedPreferencesModule);

    RetrofitSubComponent plusRetrofitSubComponent (RetrofitModule retrofitModule);

}
