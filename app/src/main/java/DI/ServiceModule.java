package DI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.JsonPlaceholderService;

@Module
public class ServiceModule {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Provides
    public JsonPlaceholderService getJsonPlaceholderService() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(JsonPlaceholderService.class);
    }
}
