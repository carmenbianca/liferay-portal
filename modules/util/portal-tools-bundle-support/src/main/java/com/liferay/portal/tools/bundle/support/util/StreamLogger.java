/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.bundle.support.util;

/**
 * @author Andrea Di Giorgi
 */
public interface StreamLogger {

	public void onCompleted();

	public void onProgress(long completed, long length);

	public void onStarted();

}