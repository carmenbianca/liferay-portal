/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

import java.io.InputStream;
import java.io.Serializable;

import java.util.Date;

/**
 * @author Michael C. Han
 */
public class ContextClassloaderReportDesignRetriever
	implements ReportDesignRetriever, Serializable {

	public ContextClassloaderReportDesignRetriever(String reportName) {
		_reportName = reportName;
	}

	@Override
	public InputStream getInputStream() {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		return contextClassLoader.getResourceAsStream(_reportName);
	}

	@Override
	public Date getModifiedDate() {
		return new Date();
	}

	@Override
	public String getReportName() {
		return _reportName;
	}

	private final String _reportName;

}