/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine;

import com.liferay.portal.kernel.resource.ResourceRetriever;

import java.util.Date;

/**
 * @author Michael C. Han
 */
public interface ReportDesignRetriever extends ResourceRetriever {

	public Date getModifiedDate();

	public String getReportName();

}