package di.module;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import di.scope.SharedPreferencesScope;

@Module
public class SharedPreferencesModule {

    public static final String SHARED_PREF = "shared_pref";

    @Provides
    @SharedPreferencesScope
    SharedPreferences provideSharedPreferences (Context context) {
        return context.getSharedPreferences("shared_pref", context.MODE_PRIVATE);
    }


}
