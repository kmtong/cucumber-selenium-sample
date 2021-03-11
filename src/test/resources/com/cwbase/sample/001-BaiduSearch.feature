# language: zh-CN
功能: 百度查询

  场景: 使用元素级别进行百度查询
    当使用谷歌浏览器
    并且访问网站"https://www.baidu.com"
    并且填写"cucumber"到"wd"
    并且点击"百度一下"按钮
    并且等待1秒后
    那么页面显示内容含有"Cucumber - 自动化测试工具"

  场景: 使用高阶百度查询
    当使用谷歌浏览器
    并且使用百度搜索"cucumber"
    那么页面显示内容含有"Cucumber - 自动化测试工具"
    当使用百度搜索"selenium webdriver"
    那么页面显示内容含有"Selenium Projects"
