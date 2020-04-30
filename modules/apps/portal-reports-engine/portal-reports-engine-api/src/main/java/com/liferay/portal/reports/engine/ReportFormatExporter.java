/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

/**
 * @author Michael C. Han
 */
public interface ReportFormatExporter {

	public void format(
			Object report, ReportRequest reportRequest,
			ReportResultContainer reportResultContainer)
		throws ReportGenerationException;

}