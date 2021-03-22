import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test2home {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTest() {
        String firstName = "Oksana";
        String lastName = "Bel";
        String userEmail = "123@yandex.ru";
        String gender = "Female";
        String mobile_Number = "4107562489";
        String month = "July";
        String year = "1991";
        String subjects = "Physics";
        String hobbies = "Sports";
        String address = "Bora-Bora";
        String state = "Uttar Pradesh";
        String city = "Lucknow";


        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("[placeholder='Mobile Number']").setValue(mobile_Number);

        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--013").click();


        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText(hobbies)).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/audi.jpg"));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(mobile_Number),
                text("13 " + month + "," + year),
                text(subjects),
                text(hobbies),
                text("audi.jpg"),
                text(address),
                text(state + " " + city));
    }
}
