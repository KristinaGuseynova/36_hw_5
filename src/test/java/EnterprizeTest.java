import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class EnterprizeTest {

    @Test
    void pageEnterprisesShouldBeOpen() {

        open("https://github.com/");
        $(withTagAndText("button","Solutions")).hover();
        $$("header a").findBy(text("Enterprise")).click();
        $("main").shouldHave(text("The AI-powered developer platform"));
    }

    @Test
    void drugNDropTestActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = $("#column-a").toWebElement();
        WebElement columnB = $("#column-b").toWebElement();

        actions()
                .clickAndHold(columnA)
                .moveToElement(columnB)
                .release()
                .perform();

        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));

    }

    @Test
    void drugNDropTestWithDrugAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));

    }
}
