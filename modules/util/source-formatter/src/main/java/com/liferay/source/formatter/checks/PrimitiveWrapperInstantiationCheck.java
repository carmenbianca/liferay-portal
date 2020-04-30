/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Hugo Huijser
 */
public class PrimitiveWrapperInstantiationCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return StringUtil.replace(
			content,
			new String[] {
				"new Boolean(", "new Byte(", "new Character(", "new Double(",
				"new Float(", "new Integer(", "new Long(", "new Short("
			},
			new String[] {
				"Boolean.valueOf(", "Byte.valueOf(", "Character.valueOf(",
				"Double.valueOf(", "Float.valueOf(", "Integer.valueOf(",
				"Long.valueOf(", "Short.valueOf("
			});
	}

}