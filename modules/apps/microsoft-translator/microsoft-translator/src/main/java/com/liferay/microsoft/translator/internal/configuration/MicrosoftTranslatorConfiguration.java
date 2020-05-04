/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.microsoft.translator.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Andrea Di Giorgi
 */
@ExtendedObjectClassDefinition(category = "localization")
@Meta.OCD(
	id = "com.liferay.microsoft.translator.internal.configuration.MicrosoftTranslatorConfiguration",
	localization = "content/Language",
	name = "microsoft-translator-configuration-name"
)
public interface MicrosoftTranslatorConfiguration {

	@Meta.AD(
		description = "subscription-key-description",
		name = "subscription-key-name", required = false
	)
	public String subscriptionKey();

}