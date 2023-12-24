import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestApp {

    public static void main(String[] args) {
        // Thiết lập thông số kết nối với thiết bị Xiaomi 2201117TG
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Xiaomi 2201117TG");
        caps.setCapability("platformName", "ANDROID");
        caps.setCapability("appium:appPackge", "com.android.calculator2");
        caps.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("appium:noReset", true);



        // Khởi tạo đối tượng AndroidDriver để kết nối với Appium Server
        AndroidDriver<AndroidElement> driver;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        // Thực hiện các thao tác kiểm thử trên ứng dụng máy tính
        AndroidElement btnFive = driver.findElement(MobileBy.id("com.miui.calculator:id/btn_5_s"));
        btnFive.click();

        AndroidElement btnPlus = driver.findElement(MobileBy.id("com.miui.calculator:id/btn_plus_s"));
        btnPlus.click();

        AndroidElement btnThree = driver.findElement(MobileBy.id("com.miui.calculator:id/btn_3_s"));
        btnThree.click();

        AndroidElement btnEquals = driver.findElement(MobileBy.id("com.miui.calculator:id/btn_mul_s"));
        btnEquals.click();

        AndroidElement btnTwo = driver.findElement(MobileBy.id("com.miui.calculator:id/btn_3_s"));
        btnTwo.click();

        AndroidElement btnEqual = driver.findElement(MobileBy.id("com.miui.calculator:id/btn_equal_s"));
        btnEqual.click();

        AndroidElement result = driver.findElement(MobileBy.id("com.miui.calculator:id/result"));
        System.out.println("Kết quả: " + result.getText());
        if (result.getText().equals("= 11")) {
            System.out.println("Passed!!!");
        }else {
            System.out.println("Failer!!!");
        }

        // Đóng kết nối và thoát chương trình kiểm

        driver.quit();
    }
}