package DI;

import android.app.Application;

import com.example.afanasyev.userlist.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ServiceModule.class,
        ActivityBuilder.class
})
@Singleton
public interface AppComponent {
    void inject(App application);

    @Component.Builder
    interface Builder {
        @BindsInstance Builder app(Application application);
        AppComponent build();
    }
}
