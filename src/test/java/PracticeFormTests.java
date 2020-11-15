import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @Test
    void fillFormSuccessfulTest() {
    }

    @Test
    void formEmailFillSuccessfulTest() {
        open("https://demoqa.com/automation-practice-form");
        $(byId("firstName")).val("Vasja");
        $(byId("lastName")).val("Pupkin");
        $(byId("userEmail")).val("vp@email.com");
        $$x("//input[@name='gender']").get(0).click();
        $(byId("dateOfBirthInput")).val("31121980");
        $(byId("userNumber")).val("1234567890");
//        $(byId("hobbies-checkbox-2")).click();
//        $(byId("hobbies-checkbox-3")).click();
//        $(byId("file-upload-button")).uploadFile().;
        $(byId("currentAddress")).val("Middle of Nowhere");
//        $(byId("react-select-3-input")).selectOptionContainingText("NCR");
//        $(byId("react-select-4-input")).selectOptionContainingText("Noida");


    }

}

