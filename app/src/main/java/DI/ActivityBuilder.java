package DI;

import com.example.afanasyev.userlist.UserListActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = { UIModule.class, ServiceModule.class })
    public abstract UserListActivity bindUserListActivity();
}
