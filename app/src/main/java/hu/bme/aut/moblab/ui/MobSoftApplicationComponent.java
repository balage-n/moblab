package hu.bme.aut.moblab.ui;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.moblab.ui.main.MainActivity;

/**
 * Created by bali on 2017. 03. 24..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}
