/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.persistence.listener;

import java.util.Dictionary;

/**
 * @author Drew Brokke
 */
public interface ConfigurationModelListener {

	public default void onAfterDelete(String pid)
		throws ConfigurationModelListenerException {
	}

	public default void onAfterSave(
			String pid, Dictionary<String, Object> properties)
		throws ConfigurationModelListenerException {
	}

	public default void onBeforeDelete(String pid)
		throws ConfigurationModelListenerException {
	}

	public default void onBeforeSave(
			String pid, Dictionary<String, Object> properties)
		throws ConfigurationModelListenerException {
	}

}