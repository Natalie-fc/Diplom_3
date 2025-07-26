package stellarburgers.tests;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.helpers.UserFactory;
import stellarburgers.models.User;
import stellarburgers.pageobjects.ForgotPasswordPage;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainPage;
import stellarburgers.pageobjects.RegisterPage;

@Epic("Аутентификация")
@Feature("Авторизация пользователя")
public class LoginPageTest extends BaseTest {

    private User user;

    @Before
    public void createUser() {
        user = UserFactory.createRandomUser();

        driver.get(RegisterPage.REGISTER_PAGE_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);
    }


    @Test
    @Story("Вход с главное страницы")
    @Description("Вход через кнопку 'Войти в аккаунт' на главной странице")
    public void loginFromMainPageTest() {

        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue("Ожидался успешный вход на главную страницу", loginPage.isLoginSuccessful());
    }

    @Test
    @Story("Вход через кнопку 'Личный кабинет'")
    @Description("Вход через кнопку 'Личный кабинет' на главной странице")
    public void loginFromProfileButtonTest() {

        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue("Ожидался успешный вход через 'Личный кабинет'", loginPage.isLoginSuccessful());
    }

    @Test
    @Story("Вход с формы регистрации")
    @Description("Вход через форму регистрации")
    public void loginFromRegisterFormTest() {
        driver.get(RegisterPage.REGISTER_PAGE_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue("Ожидался успешный вход через форму регистрации", loginPage.isLoginSuccessful());
    }

    @Test
    @Story("Вход со страницы восстановления пароля")
    @Description("Вход через форму восстановления пароля")
    public void loginFromForgotPasswordPageTest() {
        driver.get(ForgotPasswordPage.FORGOT_PASSWORD_URL);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue("Ожидался успешный вход через форму восстановления пароля", loginPage.isLoginSuccessful());
    }

}