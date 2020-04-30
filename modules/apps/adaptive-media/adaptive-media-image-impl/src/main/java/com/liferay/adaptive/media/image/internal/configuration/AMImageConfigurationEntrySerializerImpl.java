/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.configuration;

import com.liferay.adaptive.media.image.configuration.AMImageConfigurationEntry;
import com.liferay.adaptive.media.image.configuration.AMImageConfigurationEntrySerializer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true, service = AMImageConfigurationEntrySerializer.class
)
public class AMImageConfigurationEntrySerializerImpl
	implements AMImageConfigurationEntrySerializer {

	@Override
	public AMImageConfigurationEntry deserialize(String s) {
		return _amImageConfigurationEntryParser.parse(s);
	}

	@Override
	public String serialize(
		AMImageConfigurationEntry amImageConfigurationEntry) {

		return _amImageConfigurationEntryParser.getConfigurationString(
			amImageConfigurationEntry);
	}

	@Reference
	private AMImageConfigurationEntryParser _amImageConfigurationEntryParser;

}