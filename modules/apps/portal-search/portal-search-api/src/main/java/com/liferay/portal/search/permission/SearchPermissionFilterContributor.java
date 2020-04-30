/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.permission;

import java.util.Optional;

/**
 * @author Bryan Engler
 */
public interface SearchPermissionFilterContributor {

	public Optional<String> getParentEntryClassNameOptional(
		String entryClassName);

}