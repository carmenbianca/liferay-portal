/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.query;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
public interface QueryPreProcessConfiguration {

	public boolean isSubstringSearchAlways(String fieldName);

}