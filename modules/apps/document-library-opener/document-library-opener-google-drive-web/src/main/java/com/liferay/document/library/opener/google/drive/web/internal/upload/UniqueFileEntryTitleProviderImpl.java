/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.google.drive.web.internal.upload;

import com.liferay.document.library.opener.google.drive.upload.UniqueFileEntryTitleProvider;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(service = UniqueFileEntryTitleProvider.class)
public class UniqueFileEntryTitleProviderImpl
	implements UniqueFileEntryTitleProvider {

	@Override
	public String provide(long groupId, long folderId, Locale locale)
		throws PortalException {

		return _uniqueFileEntryTitleProvider.provide(groupId, folderId, locale);
	}

	@Override
	public String provide(long groupId, long folderId, String fileName)
		throws PortalException {

		return _uniqueFileEntryTitleProvider.provide(
			groupId, folderId, fileName);
	}

	@Reference
	private
		com.liferay.document.library.opener.upload.UniqueFileEntryTitleProvider
			_uniqueFileEntryTitleProvider;

}