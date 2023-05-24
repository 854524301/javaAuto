package com.qing.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class test2 {
    private static void openChrome() {
        //打开浏览器
        Path p1 = Paths.get("src", "drivers", "chromeDriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        //创建浏览器实例
        chromeDriver = new ChromeDriver();
    }

    public static ChromeDriver chromeDriver;
    public static WebElement webElement2;

    public static void main(String[] args) throws test, InterruptedException {
        openChrome();
        // get(String url)
        //访问指定ur1页面
        chromeDriver.get("https://www.baidu.com");
        // 等待3s
        //Thread.sleep(3000);
        //chromeDriver.findElement(By.id("kw")).clear();//清理id为kw的输入框中的元素
        WebElement webElement1 = chromeDriver.findElement(By.id("kw"));
        chromeDriver.findElement(By.id("kw")).sendKeys("腾讯课堂");
        chromeDriver.findElement(By.id("su")).click();//点击百度一下按钮
        // getTagName ()
        //获取元素的的标签名
        System.out.println("得到元素的标签名:" + webElement1.getTagName());
        // getAttribute(属性名)
        // 根据属性名获取元素属性值
        System.out.println("得到当前的maxlength属性:" + webElement1.getAttribute("maxlength"));
        webElement2 = chromeDriver.findElement(By.xpath("//a[text ()='设置']"));
        //getText()
        //获取当前元素的文本值
        System.out.println("得到元素的文本值:" + webElement2.getText());
        //isDisplayed()
        //查看元素是否显示
        System.out.println("元素是否显示" + webElement2.isDisplayed());
        // getCurrentUr1(
        // 获取当前页面的ur1地址
        System.out.println("当前的URI为:" + chromeDriver.getCurrentUrl());
        // getTitle()
        // 获取当前页面的标题
        System.out.println("当前的标题为:" + chromeDriver.getTitle());
        // getPageSource ()
        // 获取当前页面源代码
        //System,out,printIn("当前页面的源代码为:"+chromeDriver,getPageSource());/ / quit ()
        // 关闭驱动对象以及所有相关的窗口
        //chromeDriver.quit();
        //close()
        // 关闭当前窗口
//        System.out.println("新窗口打开前的柄:" + chromeDriver.getWindowHandle());
//        System.out.println("新窗口打开前的所有句柄:" + chromeDriver.getWindowHandles());
//        Thread.sleep(3000);
//        chromeDriver.findElement(By.xpath("//a[text()='的微博_微博']")).click();
//        Thread.sleep(1000);
//        System.out.println("新窗口打开后的句柄:" + chromeDriver.getWindowHandle());
////        System.out.println("新窗口打开后的所有句柄:" + chromeDriver.getWindowHandles());
//        //navigation对象
//        WebDriver.Navigation navigation = chromeDriver.navigate();
//        //访问京东
//        navigation.to("https://www.jd.com");
//        Thread.sleep(1000);
//        //刷新网页
//        navigation.refresh();
//        Thread.sleep(1000);
//        //回退
//        navigation.back();
//        Thread.sleep(1000);
//        //前进
//        navigation.forward();


    }
}
