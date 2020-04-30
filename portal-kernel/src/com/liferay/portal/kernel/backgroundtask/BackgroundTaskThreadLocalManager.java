/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public interface BackgroundTaskThreadLocalManager {

	public void deserializeThreadLocals(
		Map<String, Serializable> taskContextMap);

	public Map<String, Serializable> getThreadLocalValues();

	public void serializeThreadLocals(Map<String, Serializable> taskContextMap);

	public void setThreadLocalValues(
		Map<String, Serializable> threadLocalValues);

}