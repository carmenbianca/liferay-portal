/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.upload;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;

/**
 * @author Adolfo Pérez
 */
public interface UniqueFileEntryTitleProvider {

	public String provide(long groupId, long folderId, Locale locale)
		throws PortalException;

	public String provide(long groupId, long folderId, String fileName)
		throws PortalException;

}