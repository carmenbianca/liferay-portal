/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.util.JavaSourceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JavaModuleIllegalImportsCheck extends BaseFileCheck {

	@Override
	public boolean isModuleSourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		String packageName = JavaSourceUtil.getPackageName(content);

		if (!packageName.startsWith("com.liferay")) {
			return content;
		}

		// LPS-62989

		if (!absolutePath.contains("/modules/core/jaxws-osgi-bridge") &&
			!absolutePath.contains("/modules/core/portal-bootstrap") &&
			!absolutePath.contains("/modules/core/registry-") &&
			!absolutePath.contains("/modules/core/slim-runtime") &&
			(isAttributeValue(
				_CHECK_REGISTRY_IN_TEST_CLASSES_KEY, absolutePath) ||
			 (!absolutePath.contains("/test/") &&
			  !absolutePath.contains("/testIntegration/")))) {

			Matcher matcher = _registryImportPattern.matcher(content);

			if (matcher.find()) {
				addMessage(
					fileName,
					"Do not use com.liferay.registry classes in modules, see " +
						"LPS-62989");
			}
		}

		// LPS-64238

		if (content.contains("import com.liferay.util.dao.orm.CustomSQLUtil")) {
			addMessage(
				fileName,
				"Do not use com.liferay.util.dao.orm.CustomSQLUtil in " +
					"modules, see LPS-77361");
		}

		// LPS-64335

		if (content.contains("import com.liferay.util.ContentUtil")) {
			addMessage(
				fileName,
				"Do not use com.liferay.util.ContentUtil in modules, see " +
					"LPS-64335");
		}

		return content;
	}

	private static final String _CHECK_REGISTRY_IN_TEST_CLASSES_KEY =
		"checkRegistryInTestClasses";

	private static final Pattern _registryImportPattern = Pattern.compile(
		"\nimport (com\\.liferay\\.registry\\..+);");

}