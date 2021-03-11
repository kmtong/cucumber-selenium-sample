package com.cwbase.sample.browser;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cwbase.sample.context.SampleTestContext;
import com.google.common.io.Files;

import cucumber.api.java8.Zh_cn;
import lombok.extern.slf4j.Slf4j;

/**
 * 低阶浏览器操作定义
 * 
 * @author kmtong
 */
public class BrowserStepdefs implements Zh_cn {

	public BrowserStepdefs(SampleTestContext context) {
		当("使用火狐浏览器", () -> {
			context.cleanup();
			context.setWebDriver(new FirefoxDriver());
			context.getWebDriver().manage().window().maximize();
			context.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		});

		当("使用谷歌浏览器", () -> {
			context.cleanup();
			context.setWebDriver(new ChromeDriver());
			context.getWebDriver().manage().window().maximize();
			context.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		});

		当("访问网站{string}", (String string) -> {
			context.getWebDriver().get(string);
		});

		当("点击{string}按钮", (String string) -> {
			context.getWebDriver().findElement(By.xpath("//input[@value='" + string + "']")).click();
		});

		当("填写{string}到{string}", (String value, String field) -> {
			context.getWebDriver().findElement(By.name(field)).sendKeys(value);
		});

		那么("页面显示内容含有{string}", (String string) -> {
			String bodyText = context.getWebDriver().findElement(By.tagName("body")).getText();
			assertTrue("Body找不到内容: " + string, bodyText.contains(string));
		});

		当("等待{int}秒后", (Integer timeout) -> {
			Thread.sleep(timeout * 1000L);
		});

		那么("CSS元素{string}截屏到{string}", (String cssSelector, String path) -> {
			WebElement elm = context.getWebDriver().findElement(By.cssSelector(cssSelector));
			File file = new File(path);
			Files.createParentDirs(file);
			byte[] imgs = elm.getScreenshotAs(OutputType.BYTES);
			IOUtils.write(imgs, new FileOutputStream(file));
		});

		// cleanup
		After(() -> {
			context.cleanup();
		});
	}

}
