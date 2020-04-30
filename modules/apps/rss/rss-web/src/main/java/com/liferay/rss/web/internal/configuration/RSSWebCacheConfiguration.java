/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.rss.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Juergen Kappler
 */
@ExtendedObjectClassDefinition(category = "rss")
@Meta.OCD(
	id = "com.liferay.rss.web.internal.configuration.RSSWebCacheConfiguration",
	localization = "content/Language", name = "rss-web-cache-configuration-name"
)
public interface RSSWebCacheConfiguration {

	@Meta.AD(deflt = "20", name = "feed-time", required = false)
	public int feedTime();

}