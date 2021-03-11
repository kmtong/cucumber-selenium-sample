package com.cwbase.sample.baidu;

import org.openqa.selenium.By;

import com.cwbase.sample.context.SampleTestContext;

import cucumber.api.java8.Zh_cn;

/**
 * 高阶操作定义
 * 
 * @author kmtong
 */
public class BaiduSearchStepdefs implements Zh_cn {

	public BaiduSearchStepdefs(SampleTestContext context) {
		当("使用百度搜索{string}", (String search) -> {
			context.getWebDriver().get("https://www.baidu.com");
			context.getWebDriver().findElement(By.name("wd")).sendKeys(search);
			context.getWebDriver().findElement(By.xpath("//input[@value='百度一下']")).click();
			Thread.sleep(500L);
		});
	}
}