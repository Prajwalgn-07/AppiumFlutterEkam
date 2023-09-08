package ekam.example.mobile.screens;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.internal.injectors.InjectorsCacheProvider;
import io.github.ashwith.flutter.FlutterFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FlutterMobileScreen extends MobileScreen {
    protected FlutterFinder flutterFinder;

    public FlutterMobileScreen() {
      WebDriver webDriver = InjectorsCacheProvider.injectorsCache()
                                                    .getInjector()
                                                    .getInstance(WebDriver.class);
      this.flutterFinder = new FlutterFinder((RemoteWebDriver) webDriver);
    }

}
