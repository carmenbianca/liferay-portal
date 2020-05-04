/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upload;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Pei-Jung Lan
 */
public class UploadServletRequestConfigurationHelperUtil {

	public static long getMaxSize() {
		return _uploadServletRequestConfigurationHelper.getMaxSize();
	}

	public static long getMaxTries() {
		return _uploadServletRequestConfigurationHelper.getMaxTries();
	}

	public static String getTempDir() {
		return _uploadServletRequestConfigurationHelper.getTempDir();
	}

	private static volatile UploadServletRequestConfigurationHelper
		_uploadServletRequestConfigurationHelper =
			ServiceProxyFactory.newServiceTrackedInstance(
				UploadServletRequestConfigurationHelper.class,
				UploadServletRequestConfigurationHelperUtil.class,
				"_uploadServletRequestConfigurationHelper", false);

}