/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Michael C. Han
 */
public class ReportGenerationException extends PortalException {

	public ReportGenerationException() {
	}

	public ReportGenerationException(String msg) {
		super(msg);
	}

	public ReportGenerationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ReportGenerationException(Throwable cause) {
		super(cause);
	}

}