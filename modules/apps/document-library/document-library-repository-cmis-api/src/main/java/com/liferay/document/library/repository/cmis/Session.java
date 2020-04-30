/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.cmis;

import java.util.Set;

/**
 * @author Alexander Chow
 */
public interface Session {

	public void setDefaultContext(
		Set<String> filter, boolean includeAcls,
		boolean includeAllowableActions, boolean includePolicies,
		String includeRelationships, Set<String> renditionFilter,
		boolean includePathSegments, String orderBy, boolean cacheEnabled,
		int maxItemsPerPage);

}