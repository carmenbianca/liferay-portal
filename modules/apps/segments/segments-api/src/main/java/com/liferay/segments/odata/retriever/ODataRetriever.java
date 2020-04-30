/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.odata.retriever;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.List;
import java.util.Locale;

/**
 * @author David Arques
 */
public interface ODataRetriever<T extends BaseModel<?>> {

	public List<T> getResults(
			long companyId, String filterString, Locale locale, int start,
			int end)
		throws PortalException;

	public int getResultsCount(
			long companyId, String filterString, Locale locale)
		throws PortalException;

}