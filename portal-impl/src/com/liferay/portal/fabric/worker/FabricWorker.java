/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.worker;

import com.liferay.petra.process.ProcessChannel;
import com.liferay.portal.fabric.status.FabricStatus;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface FabricWorker<T extends Serializable>
	extends ProcessChannel<T> {

	public FabricStatus getFabricStatus();

}