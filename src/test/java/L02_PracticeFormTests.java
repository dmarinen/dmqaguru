import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class L02_PracticeFormTests {

    String firstname = "Vasja",
            lastname = "Pupkin",
            email = "vp@email.com",
            gender = "Male",
            number = "1234567890",
            month = "December",
            year = "1999",
            day = "31",
            subject = "Maths",
            hobby1 = "Music",
            hobby2 = "Reading",
            address = "In the Middle of Nowhere",
            state = "NCR",
            city = "Noida",
            successMessage = "Thanks for submitting the form";

    File file = new File("src/test/resources/ava.png");

    @Test
    void testFillFormSuccessful() {
        open("https://demoqa.com/automation-practice-form");
        $(byId("firstName")).val(firstname);
        $(byId("lastName")).val(lastname);
        $(byId("userEmail")).val(email);
        $x("//label[contains(text(),'Male')]").click();
        $(byId("userNumber")).val(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--031").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $(byId("uploadPicture")).uploadFile(file);
        $(byId("currentAddress")).val(address);
        $("#state").scrollTo().click();
        $("#state").shouldBe(Condition.visible); //Added to wait for dropdown menu to open
        $(byText(state)).click();
        $("#city").click();
        $("#city").shouldBe(Condition.visible); //Added to wait for dropdown menu to open
        $(byText(city)).click();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldBe(Condition.visible).shouldHave(Condition.text(successMessage));
        $("tr:nth-child(1)>td:nth-child(2)").shouldHave(Condition.text(firstname + " " + lastname));
        $("tr:nth-child(2)>td:nth-child(2)").shouldHave(Condition.text(email));
        $("tr:nth-child(3)>td:nth-child(2)").shouldHave(Condition.text(gender));
        $("tr:nth-child(4)>td:nth-child(2)").shouldHave(Condition.text(number));
        $("tr:nth-child(5)>td:nth-child(2)").shouldHave(Condition.text(day + " " + month + "," + year));
        $("tr:nth-child(6)>td:nth-child(2)").shouldHave(Condition.text(subject));
        $("tr:nth-child(7)>td:nth-child(2)").shouldHave(Condition.text(hobby1+", "+hobby2));
        $("tr:nth-child(9)>td:nth-child(2)").shouldHave(Condition.text(address));
        $("tr:nth-child(10)>td:nth-child(2)").shouldHave(Condition.text(state + " " + city));

    }

}

