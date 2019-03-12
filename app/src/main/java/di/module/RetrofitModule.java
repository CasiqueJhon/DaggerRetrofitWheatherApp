package di.module;

import java.util.concurrent.TimeUnit;

import API.ApiClient;
import dagger.Module;
import dagger.Provides;
import di.scope.ActivityScope;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    /*
    * Retrofit */

    private static final String BASE_URL = "http://samples.openweathermap.org/";

    @ActivityScope
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();

        return gsonConverterFactory;
    }

    @ActivityScope
    @Provides
    HttpLoggingInterceptor provideHttpLogginInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        return loggingInterceptor;
    }

    @ActivityScope
    @Provides
    OkHttpClient provideOKhttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @ActivityScope
    @Provides
    Retrofit privideRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory) {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(client)
                .build();
    }

    @ActivityScope
    @Provides
    ApiClient provideApiClient (Retrofit retrofit) {

        return retrofit.create(ApiClient.class);
    }



}
