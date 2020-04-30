/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

/**
 * @author Eudaldo Alonso
 */
public class WikiPageAttachmentsUtil {

	public static WikiPage getPage(long fileEntryId) throws PortalException {
		FileEntry fileEntry = PortletFileRepositoryUtil.getPortletFileEntry(
			fileEntryId);

		Folder folder = PortletFileRepositoryUtil.getPortletFolder(
			fileEntry.getFolderId());

		long resourcePrimKey = GetterUtil.getLong(folder.getName());

		return WikiPageLocalServiceUtil.getPage(resourcePrimKey);
	}

}