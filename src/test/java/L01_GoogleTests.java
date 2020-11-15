import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class L01_GoogleTests {

    @Test
    void selenideSearchTest() {
        open("https://google.com");
        $(byName("q")).setValue("qa.guru").pressEnter();
        $("html").shouldHave(Condition.text("qa.guru"));
    }
}
