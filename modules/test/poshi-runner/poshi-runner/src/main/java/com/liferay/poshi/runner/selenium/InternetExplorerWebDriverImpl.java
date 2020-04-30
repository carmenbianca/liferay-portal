/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.selenium;

import com.liferay.poshi.runner.util.PropsValues;

import org.openqa.selenium.WebDriver;

/**
 * @author Brian Wing Shun Chan
 */
public class InternetExplorerWebDriverImpl extends BaseWebDriverImpl {

	public InternetExplorerWebDriverImpl(
		String browserURL, WebDriver webDriver) {

		super(browserURL, webDriver);
	}

	@Override
	public void javaScriptMouseDown(String locator) {
		if (PropsValues.BROWSER_VERSION.equals("10.0")) {
			executeJavaScriptEvent(locator, "MSPointerEvent", "MSPointerDown");
		}
		else if (PropsValues.BROWSER_VERSION.equals("11.0")) {
			executeJavaScriptEvent(locator, "MouseEvent", "pointerdown");
		}
		else {
			super.javaScriptMouseDown(locator);
		}
	}

	@Override
	public void javaScriptMouseUp(String locator) {
		if (PropsValues.BROWSER_VERSION.equals("10.0")) {
			executeJavaScriptEvent(locator, "MSPointerEvent", "MSPointerUp");
		}
		else if (PropsValues.BROWSER_VERSION.equals("11.0")) {
			executeJavaScriptEvent(locator, "MouseEvent", "pointerup");
		}
		else {
			super.javaScriptMouseUp(locator);
		}
	}

}