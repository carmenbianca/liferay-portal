/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

import java.util.Map;

import javax.servlet.ServletContext;

/**
 * @author Michael C. Han
 */
public interface ReportEngine {

	public void compile(ReportRequest reportRequest)
		throws ReportGenerationException;

	public void destroy();

	public void execute(
			ReportRequest reportRequest,
			ReportResultContainer reportResultContainer)
		throws ReportGenerationException;

	public Map<String, String> getEngineParameters();

	public void init(ServletContext servletContext);

	public void setEngineParameters(Map<String, String> engineParameters);

}