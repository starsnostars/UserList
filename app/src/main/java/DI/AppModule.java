package DI;

import android.app.Application;

import com.example.afanasyev.userlist.App;
import com.example.afanasyev.userlist.UserListActivity;
import com.example.afanasyev.userlist.UserListViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import services.JsonPlaceholderService;

@Module
public class AppModule {

    @Provides
    public Application getApp(App app) {
        return app;
    }

    @Provides
    @Singleton
    public UserListViewModel getUserListViewModule(JsonPlaceholderService service) {
        return new UserListViewModel(service);
    }
}
