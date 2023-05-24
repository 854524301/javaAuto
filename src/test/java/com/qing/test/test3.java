package com.qing.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class test3 extends Throwable {
    public static ChromeDriver chromeDriver;

    @Test
    public void openBaidu() throws InterruptedException {
        //打开浏览器
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        //创建浏览器实例
        chromeDriver = new ChromeDriver();
        //打开本地文件(因为是用的同一文件，因此这里没有更改）
        chromeDriver.get("D:\\VsCodeword\\newWork\\vue\\demo\\test.html");
        //点击按钮
        chromeDriver.findElement(By.id("abtn")).click();
        Thread.sleep(2000);
        //switchTo.alert 找到对应的alert提示框
        //Alert alert=chromeDriver.switchTo().alert();
        //点击提示框的确定
        //alert.accept();
        //取消或x掉提示框
        //alert.dismiss();
        //控制台打印弹出框的内容
        //System.out.println(alert.getText());
        Alert alert = chromeDriver.switchTo().alert();
        Thread.sleep(2000);
        //alert.accept();//点击确定，弹出1
        //alert.dismiss();//点击取消，弹出2
        //Thread.sleep(2000);
        //alert.accept();//点击回显1/2的弹框的确定
        System.out.println(alert.getText());
    }

    @Test
    public void iframe() throws InterruptedException {
        //打开浏览器
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        //创建浏览器实例
        chromeDriver = new ChromeDriver();
        //打开本地文件(因为是用的同一文件，因此这里没有更改）
        chromeDriver.get("D:\\VsCodeword\\newWork\\vue\\demo\\test.html");
        chromeDriver.findElement(By.id("aa")).sendKeys("111");
        Thread.sleep(2000);
        chromeDriver.switchTo().frame("bframe");
        chromeDriver.findElement((By.id("bb"))).sendKeys("222");
        Thread.sleep(2000);
        chromeDriver.switchTo().frame("cframe");
        chromeDriver.findElement(By.id("cc")).sendKeys("333");
        //回到默认页面
        chromeDriver.switchTo().defaultContent();
        chromeDriver.findElement(By.id("aa")).clear();
        chromeDriver.findElement(By.id("aa")).sendKeys("回到了最外层");
    }

    @Test
    public void select() throws InterruptedException {
        //打开浏览器
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        //创建浏览器实例
        chromeDriver = new ChromeDriver();
        //打开本地文件(因为是用的同一文件，因此这里没有更改）
        chromeDriver.get("https://www.baidu.com");
        chromeDriver.findElement(By.id("s-usersetting-top")).click();
        chromeDriver.findElement(By.xpath("//div[@id='s-user-setting-menu']/div/a[2]/span")).click();
        chromeDriver.findElement(By.xpath("//span[@id='adv-setting-gpc']/div/div/i")).click();
        chromeDriver.findElement(By.xpath("//span[@id='adv-setting-gpc']/div/div[2]/div[2]/p[3]")).click();
        chromeDriver.findElement(By.xpath("//span[@id='adv-setting-gpc']/div/div")).click();
        chromeDriver.findElement(By.xpath("//span[@id='adv-setting-gpc']/div/div[2]/div[2]/p[4]")).click();
    }

    @Test
    public void shubiao() {
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        chromeDriver = new ChromeDriver();
        //鼠标操作
        chromeDriver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
        WebElement sourceElement = chromeDriver.findElement(By.id("treeDemo_2_span"));
        WebElement targetElement = chromeDriver.findElement(By.id("treeDemo_3_span"));
        //实例化actions对象，鼠标的相关操作
        Actions actions = new Actions(chromeDriver);
        actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
    }
}

