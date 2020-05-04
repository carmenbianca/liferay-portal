/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.persistence.listener;

import java.io.IOException;

import java.util.Dictionary;

/**
 * @author Drew Brokke
 */
public class ConfigurationModelListenerException extends IOException {

	public ConfigurationModelListenerException(
		String causeMessage, Class<?> configurationClass,
		Class<?> listenerClass, Dictionary properties) {

		super(
			String.format(
				"The listener %s was unable to save configuration %s.",
				listenerClass.getName(), configurationClass.getName()));

		this.causeMessage = causeMessage;
		this.configurationClass = configurationClass;
		this.listenerClass = listenerClass;
		this.properties = properties;
	}

	public final String causeMessage;
	public final Class<?> configurationClass;
	public final Class<?> listenerClass;
	public final Dictionary properties;

}