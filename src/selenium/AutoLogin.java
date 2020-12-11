/*
 * Copyright © 2019 中国电信集团系统集成有限责任公司 版权所有
 *
 * 所有文字、代码资料，版权均属中国电信集团系统集成有限责任公司
 * 任何公司或个人未经本司协议授权，不得复制、下载、存储或公开
 * 显示。违者本公司将依法追究责任。
 */

package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Description:
 *
 * @author liuyucheng
 * @date 2019/12/20 17:15
 */

public class AutoLogin {
    public WebDriver driver;
    String baseUrl = "http://192.168.19.100/a/index.html";
    @Test
    public void testBaiduSearch() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();

        driver.get(baseUrl+"/");
        WebElement inputBox = driver.findElement(By.id("user_name"));
        WebElement inputBox2 = driver.findElement(By.id("password"));
        Assert.assertTrue(inputBox.isDisplayed());
        inputBox.sendKeys("13683283532");
        Assert.assertTrue(inputBox2.isDisplayed());
        inputBox2.sendKeys("CtsiVPN*2019");
        driver.findElement(By.id("user_submit")).click();

//        driver.quit();
    }


}
