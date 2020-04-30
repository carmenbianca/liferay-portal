/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.util.JavaSourceUtil;

/**
 * @author Hugo Huijser
 */
public class JavaModuleServiceProxyFactoryCheck extends BaseFileCheck {

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

		if (content.contains(
				"ServiceProxyFactory.newServiceTrackedInstance(")) {

			addMessage(
				fileName,
				"Do not use ServiceProxyFactory.newServiceTrackedInstance in " +
					"modules, see LPS-57358");
		}

		return content;
	}

}