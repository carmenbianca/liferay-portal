/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

/**
 * @author Michael C. Han
 */
public class ReportExportException extends ReportGenerationException {

	public ReportExportException() {
	}

	public ReportExportException(String msg) {
		super(msg);
	}

	public ReportExportException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ReportExportException(Throwable cause) {
		super(cause);
	}

}