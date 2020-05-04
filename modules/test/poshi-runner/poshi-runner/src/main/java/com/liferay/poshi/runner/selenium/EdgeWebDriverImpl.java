/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Brian Wing Shun Chan
 */
public class EdgeWebDriverImpl extends BaseWebDriverImpl {

	public EdgeWebDriverImpl(String browserURL, WebDriver webDriver) {
		super(browserURL, webDriver);
	}

	@Override
	public void click(String locator) {
		if (locator.contains("x:")) {
			String url = getHtmlNodeHref(locator);

			open(url);
		}
		else {
			WebElement webElement = getWebElement(locator);

			try {
				scrollWebElementIntoView(webElement);

				webElement.click();
			}
			catch (Exception exception) {
				String message = exception.getMessage();

				if (message.contains("Element is obscured")) {
					javaScriptClick(locator);
				}
				else {
					throw exception;
				}
			}
		}
	}

	@Override
	public String getText(String locator, String timeout) throws Exception {
		return javaScriptGetText(locator, timeout);
	}

}