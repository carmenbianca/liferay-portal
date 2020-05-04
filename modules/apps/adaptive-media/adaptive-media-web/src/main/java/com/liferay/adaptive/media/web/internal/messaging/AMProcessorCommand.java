/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.messaging;

import com.liferay.adaptive.media.processor.AMProcessor;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public enum AMProcessorCommand {

	CLEAN_UP {

		@Override
		protected <M> void execute(
				AMProcessor<M, ?> amProcessor, M model, String modelId)
			throws PortalException {

			amProcessor.cleanUp(model);
		}

	},
	PROCESS {

		@Override
		protected <M> void execute(
				AMProcessor<M, ?> amProcessor, M model, String modelId)
			throws PortalException {

			amProcessor.process(model);
		}

	};

	protected abstract <M> void execute(
			AMProcessor<M, ?> amProcessor, M model, String modelId)
		throws PortalException;

}