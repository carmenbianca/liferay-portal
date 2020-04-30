/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.processor;

import com.liferay.adaptive.media.processor.AMProcessor;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * @author Adolfo Pérez
 */
public interface AMImageProcessor
	extends AMProcessor<FileVersion, AMImageProcessor> {

	public void process(FileVersion fileVersion, String configurationEntryUuid)
		throws PortalException;

}