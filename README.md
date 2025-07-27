# Diplom_2
# 🌟 Stellar Burgers UI Tests

Автоматизированные UI-тесты для веб-приложения [Stellar Burgers](https://stellarburgers.nomoreparties.site/), написанные с использованием Selenium WebDriver и JUnit.

---

## 🔧 Используемые технологии

| Технология     | Версия     |
|----------------|------------|
| Java           | 11         |
| Maven          | 3.9.0      |
| JUnit          | 4.13.2     |
| Selenium       | 4.x        |
| Allure         | 2.x        |
| WebDriver      | ChromeDriver / YandexDriver |

---
## 📁 Структура проекта

- helpers — вспомогательные классы:
    - DriverFactory — инициализация WebDriver для браузера Yandex
    - UserFactory - генерация тестовых пользователей
- models — модель данных: 
    - User - POJO-класс для хранения данных пользователя (email, пароль, имя)
- pageobjects — реализация Page Object для UI-тестирования:
    - ConstructorPage - главная страница конструктора бургеров
    - LoginPage - страница авторизации
    - RegisterPage - страница регистрации
    - ForgotPasswordPage - форма восстановления пароля
    - MainPage - нитерфейс после входа в систему
- tests — автотесты:
    - BaseTest — базовая настройка тестов
    - LoginPageTest — тесты на вход в систему
    - RegisterPageTest — тесты на регистрацию
    - ConstructorPageTest - тесты на переключение между вкладками конструктора
---

## ⚙ Настройка проекта

1. Установите JDK 11+
2. Установите Maven 3.9+
3. Убедитесь, что у вас установлен Chrome или Yandex Browser
4. Пропишите путь к браузеру и драйверу в DriverFactory.java, если путь отличается от стандартного
5. Установите Allure (для отображения отчётов)

---

## 🚀 Запуск тестов

```bash
"mvn clean test"