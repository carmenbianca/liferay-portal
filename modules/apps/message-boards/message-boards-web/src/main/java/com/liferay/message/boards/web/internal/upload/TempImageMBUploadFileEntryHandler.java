/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.upload;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ambrín Chaudhary
 */
@Component(service = TempImageMBUploadFileEntryHandler.class)
public class TempImageMBUploadFileEntryHandler
	extends BaseMBUploadFileEntryHandler {

	@Override
	protected String getParameterName() {
		return "imageSelectorFileName";
	}

}