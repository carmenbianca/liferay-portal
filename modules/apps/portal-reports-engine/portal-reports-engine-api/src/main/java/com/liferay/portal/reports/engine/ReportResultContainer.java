/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Michael C. Han
 */
public interface ReportResultContainer {

	public ReportResultContainer clone(String reportName);

	public OutputStream getOutputStream() throws IOException;

	public ReportGenerationException getReportGenerationException();

	public String getReportName();

	public byte[] getResults();

	public boolean hasError();

	public void setReportGenerationException(
		ReportGenerationException reportGenerationException);

}