/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Hugo Huijser
 */
public class JavaDeprecatedKernelClassesCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return StringUtil.replace(
			content,
			new String[] {
				"com.liferay.portal.kernel.util.CharPool",
				"com.liferay.portal.kernel.util.StringPool"
			},
			new String[] {
				"com.liferay.petra.string.CharPool",
				"com.liferay.petra.string.StringPool"
			});
	}

}