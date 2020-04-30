/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.debug.spring.extender.internal;

import com.liferay.portal.osgi.debug.SystemChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = SystemChecker.class)
public class SpringExtenderUnavailableComponentSystemChecker
	implements SystemChecker {

	@Override
	public String check() {
		return UnavailableComponentUtil.scanUnavailableComponents();
	}

	@Override
	public String getName() {
		return "Spring Extender Unavailable Component Checker";
	}

	@Override
	public String getOSGiCommand() {
		return "dm na";
	}

	@Override
	public String toString() {
		return getName();
	}

}