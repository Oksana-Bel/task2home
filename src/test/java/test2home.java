import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class test2home {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void notclosebrowser() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulFillTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Oksana");
        $("#lastName").setValue("Bel");
        $("#userEmail").setValue("123@yandex.ru");
        $(byText("Female")).click();
        $("[placeholder='Mobile Number']").setValue("4107562489");

        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--013").click();
        //  $(".subjects-auto-complete__control").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $(byText("Sports")).click();
        $("input#uploadPicture").uploadFile(new File("src/test/img/audi.jpg"));
        $("#currentAddress").setValue("Bora-Bora");
        $("#state").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Lucknow").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Oksana Bel"), text("123@yandex.ru"), text("Female"),
                text("4107562489"), text("13 July,1991"), text("Physics"), text("Sports"), text("audi.jpg"),
                text("Bora-Bora"), text("Uttar Pradesh Lucknow"));

        $("#closeLargeModal").click();
    }
}
