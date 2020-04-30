/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.context;

/**
 * @author André de Oliveira
 */
public interface FolderTitleLookup {

	public String getFolderTitle(long curFolderId);

}