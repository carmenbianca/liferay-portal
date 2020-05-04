/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Sergio González
 */
@ExtendedObjectClassDefinition(category = "blogs")
@Meta.OCD(
	id = "com.liferay.blogs.configuration.BlogsConfiguration",
	localization = "content/Language", name = "blogs-configuration-name"
)
public interface BlogsConfiguration {

	/**
	 * Set the location of the XML file containing the configuration of the
	 * default display templates for the Blogs portlet.
	 */
	@Meta.AD(
		deflt = "com/liferay/blogs/web/template/dependencies/portlet-display-templates.xml",
		name = "display-templates-config", required = false
	)
	public String displayTemplatesConfig();

	/**
	 * Set the interval in minutes on how often CheckEntryMessageListener will
	 * run to check for and display blog entries scheduled to display.
	 */
	@Meta.AD(deflt = "1", name = "entry-check-interval", required = false)
	public int entryCheckInterval();

	/**
	 * Set the interval on which the LinkbackMessageListener will run. The value
	 * is set in one minute increments.
	 */
	@Meta.AD(deflt = "5", name = "linkback-job-interval", required = false)
	public int linkbackJobInterval();

}