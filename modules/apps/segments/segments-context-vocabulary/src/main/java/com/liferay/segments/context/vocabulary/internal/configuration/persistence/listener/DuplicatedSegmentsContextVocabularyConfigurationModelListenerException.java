/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.context.vocabulary.internal.configuration.persistence.listener;

import com.liferay.portal.configuration.persistence.listener.ConfigurationModelListenerException;

import java.util.Dictionary;

/**
 * @author Cristina González
 */
public class
	DuplicatedSegmentsContextVocabularyConfigurationModelListenerException
		extends ConfigurationModelListenerException {

	public DuplicatedSegmentsContextVocabularyConfigurationModelListenerException(
		String causeMessage, Class<?> configurationClass,
		Class<?> listenerClass, Dictionary properties) {

		super(causeMessage, configurationClass, listenerClass, properties);
	}

}