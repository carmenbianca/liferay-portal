/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Michael C. Han
 * @author Gavin Wan
 */
public class ReportRequest implements Serializable {

	public ReportRequest(
		ReportRequestContext reportRequestContext,
		ReportDesignRetriever reportDesignRetriever,
		Map<String, String> reportParameters, String reportFormat) {

		_reportRequestContext = reportRequestContext;
		_reportDesignRetriever = reportDesignRetriever;
		_reportParameters = reportParameters;

		_reportFormat = ReportFormat.parse(reportFormat);
	}

	public ReportDesignRetriever getReportDesignRetriever() {
		return _reportDesignRetriever;
	}

	public ReportFormat getReportFormat() {
		return _reportFormat;
	}

	public Map<String, String> getReportParameters() {
		return _reportParameters;
	}

	public ReportRequestContext getReportRequestContext() {
		return _reportRequestContext;
	}

	public void setReportDesignRetriever(
		ReportDesignRetriever reportDesignRetriever) {

		_reportDesignRetriever = reportDesignRetriever;
	}

	public void setReportFormat(ReportFormat reportFormat) {
		_reportFormat = reportFormat;
	}

	public void setReportParameters(Map<String, String> reportParameters) {
		_reportParameters.putAll(reportParameters);
	}

	public void setReportRequestContext(
		ReportRequestContext reportRequestContext) {

		_reportRequestContext = reportRequestContext;
	}

	private ReportDesignRetriever _reportDesignRetriever;
	private ReportFormat _reportFormat;
	private final Map<String, String> _reportParameters;
	private ReportRequestContext _reportRequestContext;

}