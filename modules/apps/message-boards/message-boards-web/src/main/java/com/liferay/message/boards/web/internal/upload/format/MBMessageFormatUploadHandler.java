/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.upload.format;

import com.liferay.message.boards.web.internal.util.MBAttachmentFileEntryReference;

import java.util.List;

/**
 * @author Alejandro Tardín
 */
public interface MBMessageFormatUploadHandler {

	public String replaceImageReferences(
		String body,
		List<MBAttachmentFileEntryReference> mbAttachmentFileEntryReferences);

}