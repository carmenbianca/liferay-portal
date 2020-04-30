/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.antisamy.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Tomas Polesovsky
 */
@ExtendedObjectClassDefinition(category = "security-tools")
@Meta.OCD(
	id = "com.liferay.portal.security.antisamy.configuration.AntiSamyConfiguration",
	localization = "content/Language", name = "anti-samy-configuration-name"
)
public interface AntiSamyConfiguration {

	@Meta.AD(deflt = "true", name = "enabled", required = false)
	public boolean enabled();

	@Meta.AD(
		deflt = "/META-INF/resources/sanitizer-configuration.xml",
		name = "configuration-file-url", required = false
	)
	public String configurationFileURL();

	@Meta.AD(name = "blacklist", required = false)
	public String[] blacklist();

	@Meta.AD(
		deflt = "com.liferay.blogs.model.BlogsEntry|com.liferay.fragment.model.FragmentEntry|com.liferay.journal.model.JournalArticle",
		name = "whitelist", required = false
	)
	public String[] whitelist();

}