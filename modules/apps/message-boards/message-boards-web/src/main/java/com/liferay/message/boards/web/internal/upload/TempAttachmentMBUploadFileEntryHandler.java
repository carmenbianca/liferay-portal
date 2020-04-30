/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.upload;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(service = TempAttachmentMBUploadFileEntryHandler.class)
public class TempAttachmentMBUploadFileEntryHandler
	extends BaseMBUploadFileEntryHandler {

	@Override
	protected String getParameterName() {
		return "file";
	}

}