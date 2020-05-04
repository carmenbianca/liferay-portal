/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Roberto Díaz
 */
@ExtendedObjectClassDefinition(category = "wiki")
@Meta.OCD(
	id = "com.liferay.wiki.configuration.WikiFileUploadConfiguration",
	localization = "content/Language",
	name = "wiki-file-uploads-configuration-name"
)
public interface WikiFileUploadConfiguration {

	@Meta.AD(
		deflt = "*",
		description = "allowed-wiki-attachment-mime-types-description",
		name = "allowed-wiki-attachment-mime-types", required = false
	)
	public String[] attachmentMimeTypes();

	@Meta.AD(
		deflt = "104857600", name = "maximum-wiki-attachment-size",
		required = false
	)
	public long attachmentMaxSize();

}