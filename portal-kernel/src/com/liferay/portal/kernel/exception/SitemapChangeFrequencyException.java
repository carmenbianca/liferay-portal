/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class SitemapChangeFrequencyException extends PortalException {

	public SitemapChangeFrequencyException() {
	}

	public SitemapChangeFrequencyException(String msg) {
		super(msg);
	}

	public SitemapChangeFrequencyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SitemapChangeFrequencyException(Throwable cause) {
		super(cause);
	}

}