package stellarburgers.tests;

import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.pageobjects.RegisterPage;

import java.time.Duration;

@Epic("Регистрация")
@Feature("Форма регистрации пользователя")
public class RegisterPageTest extends BaseTest {

    @Before
    public void openRegisterPage() {
        driver.get(RegisterPage.REGISTER_PAGE_URL);
    }

    @Test
    @Story("Некорректная регистрация")
    @Description("Ошибка при регистрации с коротким паролем")
    public void registerWithShortPasswordShowsErrorTest() {

        RegisterPage registerPage = new RegisterPage(driver);

        String name = RandomStringUtils.randomAlphabetic(5);
        String email = RandomStringUtils.randomAlphabetic(7) + "@yandex.ru";
        String shortPassword = "123";

        registerPage.fillRegisterForm(name, email, shortPassword);

        Assert.assertTrue("Ожидалась ошибка 'Некорректный пароль'",
                registerPage.waitForPasswordError());
    }

    @Test
    @Story("Успешная регистрация")
    @Description("Успешная регистрация с валидными данными и переход на страницу входа")
    public void successfulRegistrationRedirectsToLoginPageTest() {
        RegisterPage registerPage = new RegisterPage(driver);

        String name = RandomStringUtils.randomAlphabetic(5);
        String email = RandomStringUtils.randomAlphabetic(7) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(8);

        registerPage.fillRegisterForm(name, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Вход']")));

        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue("После регистрации ожидался переход на страницу входа", actualUrl.contains("/login"));
    }
}
