/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.internal.dto.v1_0.util;

import com.liferay.document.library.util.DLURLHelper;
import com.liferay.headless.delivery.dto.v1_0.ContentDocument;
import com.liferay.portal.kernel.repository.model.FileEntry;

/**
 * @author Javier Gamarra
 */
public class ContentDocumentUtil {

	public static ContentDocument toContentDocument(
			DLURLHelper dlURLHelper, FileEntry fileEntry)
		throws Exception {

		return new ContentDocument() {
			{
				contentType = "Document";
				contentUrl = dlURLHelper.getPreviewURL(
					fileEntry, fileEntry.getFileVersion(), null, "", false,
					false);
				description = fileEntry.getDescription();
				encodingFormat = fileEntry.getMimeType();
				fileExtension = fileEntry.getExtension();
				id = fileEntry.getFileEntryId();
				sizeInBytes = fileEntry.getSize();
				title = fileEntry.getTitle();
			}
		};
	}

}