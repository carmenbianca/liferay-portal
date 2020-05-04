/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.google.drive.upload;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author     Adolfo Pérez
 * @deprecated As of Mueller (7.2.x), replaced by
 *             com.liferay.document.library.opener.upload.UniqueFileEntryTitleProvider
 */
@Deprecated
@ProviderType
public interface UniqueFileEntryTitleProvider {

	public String provide(long groupId, long folderId, Locale locale)
		throws PortalException;

	public String provide(long groupId, long folderId, String fileName)
		throws PortalException;

}