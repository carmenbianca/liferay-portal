/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.index;

/**
 * @author Michael C. Han
 */
public interface IndexNameBuilder {

	public String getIndexName(long companyId);

}