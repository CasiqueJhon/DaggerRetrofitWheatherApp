package di.component;


import com.jhonisaac.daggerretrofitwheatherapp.MainActivity;

import dagger.Subcomponent;
import di.scope.ActivityScope;
import di.module.RetrofitModule;
import di.module.SharedPreferencesModule;

@ActivityScope
@Subcomponent(modules = RetrofitModule.class)
public interface RetrofitSubComponent {
    void inject(MainActivity mainActivity);

    SharedPreferencesSubComponent plusSharedPreferencesSubComponent (SharedPreferencesModule sharedPreferencesModule);

}
