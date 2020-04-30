/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Drew Brokke
 */
@ExtendedObjectClassDefinition(category = "web-content")
@Meta.OCD(
	id = "com.liferay.journal.configuration.JournalFileUploadsConfiguration",
	localization = "content/Language",
	name = "journal-file-uploads-configuration-name"
)
public interface JournalFileUploadsConfiguration {

	@Meta.AD(
		deflt = ".gif,.jpeg,.jpg,.png", name = "allowed-file-extensions",
		required = false
	)
	public String[] imageExtensions();

	@Meta.AD(
		deflt = "51200", name = "maximum-file-size-small-image",
		required = false
	)
	public long smallImageMaxSize();

}