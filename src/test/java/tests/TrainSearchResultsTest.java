package tests;

import business.CustomerOperations;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SoftAsserts.class})
public class TrainSearchResultsTest extends BaseTest {
    CustomerOperations customerOps = new CustomerOperations();

    @Test
    public void searchResultsCommonVerifications() {
        customerOps.fillTicketsForm("Минск-Пассажирский", "Молодечно", "02.04.2020");
        Assert.assertTrue(customerOps.verifyOneWayRadioButtonSelectedByDefault());
        customerOps.verifyFilterByEregistration();
        customerOps.verifyFourDateFilters();
        Assert.assertTrue(customerOps.verifyImagesQuantity(5));
    }
}
