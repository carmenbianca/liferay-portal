/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.documentlibrary.messaging;

import com.liferay.document.library.kernel.util.PDFProcessorUtil;
import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * @author Alexander Chow
 */
public class PDFProcessorMessageListener extends BaseProcessorMessageListener {

	@Override
	protected void generate(
			FileVersion sourceFileVersion, FileVersion destinationFileVersion)
		throws Exception {

		PDFProcessorUtil.generateImages(
			sourceFileVersion, destinationFileVersion);
	}

}