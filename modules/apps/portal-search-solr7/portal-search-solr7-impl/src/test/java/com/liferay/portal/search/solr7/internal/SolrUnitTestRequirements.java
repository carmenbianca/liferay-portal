/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal;

/**
 * @author André de Oliveira
 */
public class SolrUnitTestRequirements {

	public static boolean isSolrExternallyStartedByDeveloper() {
		return Boolean.valueOf(
			System.getProperty(
				"com.liferay.portal.search.solr7.test.unit.started"));
	}

}