/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.util;

/**
 * Provides a default template for those JournalArticle instances which has no
 * DDM template defined.
 *
 * @author Pavel Savinov
 */
public interface JournalDefaultTemplateProvider {

	/**
	 * Default template language type. <code>ftl</code>, <code>vm</code> or
	 * <code>xsl</code>.
	 *
	 * @return Default template language type.
	 */
	public String getLanguage();

	/**
	 * Default template script.
	 *
	 * @param  ddmStructureId ID of the DDM structure to provide a template for.
	 * @return Default template script text.
	 */
	public String getScript(long ddmStructureId) throws Exception;

	/**
	 * Defines if default template is cacheable.
	 *
	 * @return <code>true</code> if default template is cacheable,
	 *         <code>false</code> otherwise.
	 */
	public boolean isCacheable();

}