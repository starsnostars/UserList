package DI;

import com.example.afanasyev.userlist.UserListAdapter;
import com.example.afanasyev.userlist.UserListViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import services.JsonPlaceholderService;

@Module
public class UIModule {
    @Provides
    public UserListAdapter getUserListAdapter() {
        return new UserListAdapter();
    }
}
