/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.repository.registry.RepositoryClassDefinition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Adolfo Pérez
 */
public class RepositoryClassDefinitionUtil {

	public static final String getRepositoryClassDefinitionId(
		RepositoryClassDefinition repositoryClassDefinition) {

		Matcher matcher = _pattern.matcher(
			repositoryClassDefinition.getClassName());

		return matcher.replaceAll(StringPool.DASH);
	}

	private static final Pattern _pattern = Pattern.compile("\\W");

}