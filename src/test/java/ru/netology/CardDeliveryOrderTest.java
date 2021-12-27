package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class CardDeliveryOrderTest {



    public static String generateDate (int days){
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void shouldSendCompletedForm3DaysDate() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedForm4DaysDate() {
        String planningDate = generateDate(4);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedForm10DaysDate() {
        String planningDate = generateDate(10);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormTwoLetterName() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Ко Ян");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormOneLetterName() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("К Я");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormWithNameOnly() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormWithSurnameOnly() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormWithHyphenatedName() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванова Анна-Мария");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormWithHyphenatedSurname() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Салтыков-Щедрин Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormWithHyphenatedSurnameAndName() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Салтыков-Щедрин Иван-Петр");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormNumberStartingWith8() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+89012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormNumberStartingWith9() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+99012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormNumberStartingWith1() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+12109062767");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormNumberStartingWith0() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+02109062767");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormNumberSameDigits() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+99999999999");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormStPetersburg() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormSimferopol() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Симферополь");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormBarnaul() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Барнаул");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormVladivostok() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Владивосток");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendCompletedFormNaryanMar() {
        String planningDate = generateDate(3);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Нарьян-Мар");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $x("//*[@name='name']").setValue("Иванов Иван");
        $x("//*[@name='phone']").setValue("+79012345678");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }









}
