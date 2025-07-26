package stellarburgers.tests;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobjects.ConstructorPage;

@Epic("Конструктор бургера")
@Feature("Переход по вкладкам ингредиентов")
public class ConstructorPageTest extends BaseTest {

    private ConstructorPage constructorPage;

    @Before
    public void openConstructorPage() {
        driver.get(ConstructorPage.MAIN_PAGE_URL);
        constructorPage = new ConstructorPage(driver);

    }

    @Test
    @Description("Переход к разделу 'Соусы'")
    public void switchToSaucesTabTest() {
        constructorPage.clickSaucesTab();
        String activeTab = constructorPage.getActiveTabText();
        Assert.assertEquals("Соусы", activeTab);
    }

    @Test
    @Description("Переход к разделу 'Начинки'")
    public void switchToFillingsTabTest() {
        constructorPage.clickFillingsTab();
        String activeTab = constructorPage.getActiveTabText();
        Assert.assertEquals("Начинки", activeTab);
    }

    @Test
    @Description("Переход к разделу 'Булки'")
    public void switchToBunsTabTest() {
        constructorPage.clickSaucesTab();
        constructorPage.waitForActiveTab("Соусы");
        constructorPage.clickBunsTab();
        constructorPage.waitForActiveTab("Булки");
        String activeTab = constructorPage.getActiveTabText();
        Assert.assertEquals("Булки", activeTab);
    }
}
