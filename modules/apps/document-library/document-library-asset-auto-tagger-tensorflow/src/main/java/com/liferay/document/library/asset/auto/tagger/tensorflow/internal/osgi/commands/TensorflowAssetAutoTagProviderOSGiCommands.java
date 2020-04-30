/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.asset.auto.tagger.tensorflow.internal.osgi.commands;

import com.liferay.document.library.asset.auto.tagger.tensorflow.internal.util.TensorflowProcessHolder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = {
		"osgi.command.function=" + TensorflowAssetAutoTagProviderOSGiCommands.RESET_PROCESS_COUNTER,
		"osgi.command.scope=" + TensorflowAssetAutoTagProviderOSGiCommands.SCOPE
	},
	service = TensorflowAssetAutoTagProviderOSGiCommands.class
)
public class TensorflowAssetAutoTagProviderOSGiCommands {

	public static final String RESET_PROCESS_COUNTER = "resetProcessCounter";

	public static final String SCOPE = "tensorflowAssetAutoTagProvider";

	public void resetProcessCounter() {
		TensorflowProcessHolder.resetCounter();
	}

}