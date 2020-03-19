package tests;

import core.CustomTestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({CustomTestListener.class})
public abstract class BaseTest {

    @BeforeTest
    public void openSite() {

    }
}
