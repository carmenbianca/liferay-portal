/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Hugo Huijser
 * @author Peter Shin
 */
public class JavaUnsafeCastingCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		for (String unsafeClassName : _UNSAFE_CLASS_NAMES) {
			int pos = -1;

			while (true) {
				pos = content.indexOf("(" + unsafeClassName + ")", pos + 1);

				if (pos == -1) {
					break;
				}

				String message = "Unsafe casting for '" + unsafeClassName + "'";

				addMessage(fileName, message, getLineNumber(content, pos));
			}
		}

		return content;
	}

	private static final String[] _UNSAFE_CLASS_NAMES = {
		"LiferayPortletRequest", "LiferayPortletResponse"
	};

}