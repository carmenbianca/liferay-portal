/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.checks.util.JavaSourceUtil;

/**
 * @author Hugo Huijser
 */
public class JavaDataAccessConnectionCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		String packageName = JavaSourceUtil.getPackageName(content);

		if (packageName.matches(".*\\.upgrade(\\.v[_0-9]+)?") ||
			packageName.endsWith(".verify")) {

			content = StringUtil.replace(
				content, "DataAccess.getConnection",
				"DataAccess.getUpgradeOptimizedConnection");
		}

		return content;
	}

}