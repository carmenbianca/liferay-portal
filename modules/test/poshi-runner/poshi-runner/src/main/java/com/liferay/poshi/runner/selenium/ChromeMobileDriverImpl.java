/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.selenium;

import com.liferay.poshi.runner.util.PropsValues;

import io.appium.java_client.TouchAction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;

/**
 * @author Kenji Heigel
 */
public class ChromeMobileDriverImpl extends BaseMobileDriverImpl {

	public ChromeMobileDriverImpl(String browserURL, WebDriver webDriver) {
		super(browserURL, webDriver);
	}

	@Override
	public void hideKeyboard() {
		context("NATIVE_APP");

		boolean keyboardVisible = false;

		try {
			keyboardVisible = isKeyboardVisible();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		if (keyboardVisible) {
			super.hideKeyboard();
		}

		context("WEBVIEW_1");
	}

	@Override
	public boolean isInViewport(String locator) {
		return true;
	}

	public boolean isKeyboardVisible() throws Exception {
		Runtime runtime = Runtime.getRuntime();

		StringBuilder sb = new StringBuilder(4);

		sb.append(PropsValues.MOBILE_ANDROID_HOME);
		sb.append("/platform-tools/adb -s ");
		sb.append(PropsValues.MOBILE_DEVICE_NAME);
		sb.append(" shell dumpsys input_method | grep mInputShown");

		Process process = runtime.exec(sb.toString());

		InputStreamReader inputStreamReader = new InputStreamReader(
			process.getInputStream());

		BufferedReader inputBufferedReader = new BufferedReader(
			inputStreamReader);

		String inputShownString = inputBufferedReader.readLine();

		inputShownString = inputShownString.replaceAll(".*mInputShown=", "");

		return Boolean.parseBoolean(inputShownString);
	}

	@Override
	protected void tap(String locator) {
		TouchAction touchAction = new TouchAction(this);

		hideKeyboard();

		super.swipeWebElementIntoView(locator);

		int elementPositionCenterX = getElementPositionCenterX(locator);

		int screenPositionX = elementPositionCenterX * 2;

		int elementPositionCenterY = getElementPositionCenterY(locator);
		int navigationBarHeight = 162;
		int viewportPositionTop = getScrollOffsetY();

		int screenPositionY =
			((elementPositionCenterY - viewportPositionTop) * 2) +
				navigationBarHeight;

		context("NATIVE_APP");

		touchAction.tap(screenPositionX, screenPositionY);

		touchAction.perform();

		context("WEBVIEW_1");
	}

}