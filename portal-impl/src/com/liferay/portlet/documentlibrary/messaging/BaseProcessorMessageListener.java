/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.documentlibrary.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * @author Alexander Chow
 */
public abstract class BaseProcessorMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		Object[] array = (Object[])message.getPayload();

		FileVersion sourceFileVersion = (FileVersion)array[0];
		FileVersion destinationFileVersion = (FileVersion)array[1];

		try {
			generate(sourceFileVersion, destinationFileVersion);
		}
		catch (Exception exception) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to process file version " +
						destinationFileVersion.getFileVersionId(),
					exception);
			}
		}
	}

	protected abstract void generate(
			FileVersion sourceFileVersion, FileVersion destinationFileVersion)
		throws Exception;

	private static final Log _log = LogFactoryUtil.getLog(
		BaseProcessorMessageListener.class);

}