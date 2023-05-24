package com.qing.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class test extends Throwable {
    public ChromeDriver chromeDriver;

    //beforeclass表示在整个测试类运行之前需要进行的操作
    @BeforeClass
    public void setUpEnv() {
        //打开浏览器
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        //创建浏览器实例
        chromeDriver = new ChromeDriver();
    }


    @Test
    public void openBaidu() throws InterruptedException {
//        webDriver.manage().window().maximize();//最大化浏览器
        //在driver实例化完成后设置隐形等待，设置超时的时间为5s
        // chromeDriver.manage().timeouts().implicitlyWait(time（超时的时间）, unit（时间的单位）);
//        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeDriver.get("https://www.baidu.com");//打开百度，测试的登录框的地址
//        定位百度的搜索框元素，并且输入数据(ID定位) ——唯一的
        chromeDriver.findElement(By.id("kw")).sendKeys("腾讯课堂");
        chromeDriver.findElement(By.id("su")).click();
        //代码执行太快，导致UI没有立马展示出来，造成两者不同步，从而元素找不到
//        Thread.sleep(3000);
        //显性等待，以ExpectedConditions.visibilityOfElementLocated为例
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' - 百度百科']")));

        chromeDriver.findElement(By.xpath("//a[text()=' - 百度百科']")).click();

    }

    //所有的测试操作结束后，运行的操作
    @AfterClass
    public void tearDownEnv() throws InterruptedException {
        Thread.sleep(5000);
        //关掉浏览器
        chromeDriver.quit();
    }

}
