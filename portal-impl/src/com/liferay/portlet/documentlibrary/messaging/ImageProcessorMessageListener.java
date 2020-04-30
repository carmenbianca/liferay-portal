/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.documentlibrary.messaging;

import com.liferay.document.library.kernel.util.ImageProcessorUtil;
import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * @author Sergio González
 */
public class ImageProcessorMessageListener
	extends BaseProcessorMessageListener {

	@Override
	protected void generate(
			FileVersion sourceFileVersion, FileVersion destinationFileVersion)
		throws Exception {

		ImageProcessorUtil.generateImages(
			sourceFileVersion, destinationFileVersion);
	}

}