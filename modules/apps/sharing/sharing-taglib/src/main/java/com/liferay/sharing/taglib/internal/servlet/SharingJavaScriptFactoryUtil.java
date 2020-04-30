/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.taglib.internal.servlet;

import com.liferay.sharing.display.context.util.SharingJavaScriptFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(immediate = true, service = {})
public class SharingJavaScriptFactoryUtil {

	public static final SharingJavaScriptFactory getSharingJavaScriptFactory() {
		return _sharingJavaScriptFactory;
	}

	@Reference(unbind = "-")
	protected void setSharingOnclickMethodFactory(
		SharingJavaScriptFactory sharingJavaScriptFactory) {

		_sharingJavaScriptFactory = sharingJavaScriptFactory;
	}

	private static SharingJavaScriptFactory _sharingJavaScriptFactory;

}