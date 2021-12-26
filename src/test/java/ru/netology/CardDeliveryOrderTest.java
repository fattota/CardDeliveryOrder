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






}
