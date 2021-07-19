import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;


public class StepImplementation extends BaseTest {

    @Step("<id> id li ve <x> isimli elemente tıkla")
    public void clickById(String id, String x){
        appiumFluentWait.until(ExpectedConditions.elementToBeClickable(appiumDriver.findElement(By.id(id))));
        appiumDriver.findElement(By.id(id)).click();
        Logger.info(x + " isimli butona tıklandı");
    }

    @Step("<z> isimli sayfa açıldıysa <id> li elementin boş olup olmadığını kontrol et")
    public void assertion(String z,String id ){
        Assert.assertNotNull(z + "açılmadı",appiumDriver.findElement(By.id(id)));
        Logger.info(z + " sayfası açıldı");

    }

    @Step("<xpath> xpath li ve <x> isimli elemente tıkla")
    public void clickByXpath(String xpath, String x){
        appiumFluentWait.until(ExpectedConditions.elementToBeClickable(appiumDriver.findElement(By.xpath(xpath))));
        appiumDriver.findElement(By.xpath(xpath)).click();
        Logger.info(x + " isimli butona tıklandı");

    }

    @Step("Sayfayı aşağıya kaydır")
    public void scrollToBottom() throws InterruptedException {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int start_x = (int) (dimension.width*0.5);
        int start_y = (int) (dimension.height*0.8);

        int end_x = (int) (dimension.width*0.5);
        int end_y = (int) (dimension.height*0.2);
        for(int i=0; i<50; i++){
            TouchAction action =
                    new TouchAction((PerformsTouchActions) appiumDriver)
                            .press(PointOption.point(start_x, start_y))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                            .moveTo(PointOption.point(end_x, end_y))
                            .release().perform();

        }
        Logger.info("Sayfa, sayfa sonuna kadar aşağıya kaydırıldı.");


    }

    @Step("<x> kadar bekle")
    public void waitForSecond(int x) throws InterruptedException {
        Thread.sleep(1000*x);
        Logger.info(x + " saniye kadar beklendi");
    }



}
