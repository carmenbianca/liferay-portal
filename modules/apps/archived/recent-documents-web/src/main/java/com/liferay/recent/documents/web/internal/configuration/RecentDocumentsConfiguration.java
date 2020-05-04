/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.recent.documents.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(category = "documents-and-media")
@Meta.OCD(
	id = "com.liferay.recent.documents.web.internal.configuration.RecentDocumentsConfiguration",
	localization = "content/Language",
	name = "recent-documents-configuration-name"
)
public interface RecentDocumentsConfiguration {

	@Meta.AD(
		deflt = "1", description = "check-file-ranks-interval-help",
		name = "check-file-ranks-interval", required = false
	)
	public int checkFileRanksInterval();

}