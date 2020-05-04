/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.documentlibrary.messaging;

import com.liferay.document.library.kernel.util.RawMetadataProcessorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * @author Miguel Pastor
 */
public class RawMetadataProcessorMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		FileVersion fileVersion = (FileVersion)message.getPayload();

		try {
			RawMetadataProcessorUtil.saveMetadata(fileVersion);
		}
		catch (Exception exception) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to save metadata for file version " +
						fileVersion.getFileVersionId(),
					exception);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		RawMetadataProcessorMessageListener.class);

}