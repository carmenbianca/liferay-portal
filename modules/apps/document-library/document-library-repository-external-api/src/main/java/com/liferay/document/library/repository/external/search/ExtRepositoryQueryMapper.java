/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.external.search;

import com.liferay.portal.kernel.search.SearchException;

import java.util.Date;

/**
 * @author Iván Zaera
 * @author Sergio González
 */
public interface ExtRepositoryQueryMapper {

	public Date formatDateParameterValue(String fieldName, String fieldValue)
		throws SearchException;

	public String formatParameterValue(String fieldName, String fieldValue)
		throws SearchException;

}