package hu.bme.aut.moblab.test;

/**
 * Created by bali on 2017. 05. 14..
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bme.aut.moblab.BuildConfig;
import hu.bme.aut.moblab.ui.highscore.HighscorePresenter;
import hu.bme.aut.moblab.ui.highscore.HighscoreScreen;
import hu.bme.aut.moblab.ui.main.MainPresenter;
import hu.bme.aut.moblab.ui.main.MainScreen;
import hu.bme.aut.moblab.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.moblab.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ResultTest {

    private HighscorePresenter highscorePresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        highscorePresenter = new HighscorePresenter();
    }

    @Test
    public void testResult() {
        HighscoreScreen highscoreScreen = mock(HighscoreScreen.class);
        highscorePresenter.attachScreen(highscoreScreen);
        highscorePresenter.getResults();

        ArgumentCaptor<String> todosCaptor = ArgumentCaptor.forClass(String.class);
        verify(highscoreScreen, times(2)).showMessage(todosCaptor.capture());

        List<String> capturedTodos = todosCaptor.getAllValues();
        assertEquals("todo one", capturedTodos.get(0));
        assertEquals("todo two", capturedTodos.get(1));
    }



    @After
    public void tearDown() {
        highscorePresenter.detachScreen();
    }
}