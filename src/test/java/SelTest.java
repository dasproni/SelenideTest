import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelTest {

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.startMaximized = true;
        Configuration.timeout = 5;
    }
    @After
    public void after(){
        System.out.println("Тест завершен");
    }
    @Test
    public void printInterestingText() throws InterruptedException {

         open("https://dev.n7lanit.ru/");
        $(By.xpath("//div[@class='nav nav-guest']/button[@class='btn navbar-btn btn-default btn-sign-in']")).click();
        $(By.xpath("//div[@class='control-input']/input[@id='id_username']")).shouldHave(Condition.appear).val("dasproni");
        $(By.xpath("//div[@class='control-input']/input[@id='id_password']")).shouldHave(Condition.appear).val("Cosmopolitanzxcv123456789").pressEnter();
        $(By.xpath("//div[@id='user-menu-mount']//li[@class='dropdown']/a/img")).shouldBe(Condition.visible);
        $(By.xpath("//div[@class='media-body']/a[@href='/t/new-topic-vegas/909/']")).click();
        $(By.xpath("//textarea[@id='editor-textarea']")).val("Давайте спрева перекусим, дружелюбие появится потом").shouldHave(Condition.visible);
        $(By.xpath("//button[@class='btn btn-primary btn-sm pull-right'][@type='submit']")).click();
        $(By.xpath("//div[@class='post-body']/article[last()]")).shouldBe(Condition.visible);
        $(By.xpath("//ul[@class='nav navbar-nav']")).click();

    }
}

