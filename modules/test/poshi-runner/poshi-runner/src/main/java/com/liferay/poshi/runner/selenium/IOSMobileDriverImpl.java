/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.selenium;

import io.appium.java_client.TouchAction;

import org.openqa.selenium.WebDriver;

/**
 * @author Kenji Heigel
 */
public class IOSMobileDriverImpl extends BaseMobileDriverImpl {

	public IOSMobileDriverImpl(String browserURL, WebDriver webDriver) {
		super(browserURL, webDriver);
	}

	@Override
	protected void tap(String locator) {
		TouchAction touchAction = new TouchAction(this);

		int screenPositionX = getElementPositionCenterX(locator);

		int navigationBarHeight = 44;

		int screenPositionY =
			getElementPositionCenterY(locator) + navigationBarHeight;

		context("NATIVE_APP");

		touchAction.tap(screenPositionX, screenPositionY);

		touchAction.perform();

		context("WEBVIEW_1");
	}

}