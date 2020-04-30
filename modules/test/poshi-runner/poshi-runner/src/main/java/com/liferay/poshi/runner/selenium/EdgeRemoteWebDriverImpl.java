/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.selenium;

import org.openqa.selenium.WebDriver;

/**
 * @author Brian Wing Shun Chan
 */
public class EdgeRemoteWebDriverImpl extends EdgeWebDriverImpl {

	public EdgeRemoteWebDriverImpl(String browserURL, WebDriver webDriver) {
		super(browserURL, webDriver);
	}

}