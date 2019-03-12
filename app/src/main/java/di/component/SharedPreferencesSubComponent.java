package di.component;


import com.jhonisaac.daggerretrofitwheatherapp.MainActivity2;

import dagger.Subcomponent;
import di.module.SharedPreferencesModule;
import di.scope.SharedPreferencesScope;

@SharedPreferencesScope
@Subcomponent(modules = SharedPreferencesModule.class)
public interface SharedPreferencesSubComponent {
    void inject(MainActivity2 mainActivity2);

}
