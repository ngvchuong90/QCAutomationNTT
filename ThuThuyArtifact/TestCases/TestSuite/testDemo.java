package TestSuite;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDemo extends configMulti{
	
    @Test(dataProvider = "dp")
    public void testMethod(String url) {
        Reporter.log("Launching the URL [" + url + "] on Thread [" + Thread.currentThread().getId() + "]", true);
        driver().get(url);
        Reporter.log("Page Title :" + driver().getTitle(), true);
    }

    @DataProvider(name = "dp", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"http://www.google.com"},
                {"http://www.stackoverflow.com"},
                {"http://facebook.com"}
        };
    }
}
