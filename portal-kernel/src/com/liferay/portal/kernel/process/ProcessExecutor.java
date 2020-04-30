/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.process;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface ProcessExecutor {

	public <T extends Serializable> ProcessChannel<T> execute(
			ProcessConfig processConfig, ProcessCallable<T> processCallable)
		throws ProcessException;

}