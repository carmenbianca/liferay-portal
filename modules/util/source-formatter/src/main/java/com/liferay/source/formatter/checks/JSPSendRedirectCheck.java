/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Hugo Huijser
 */
public class JSPSendRedirectCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (fileName.endsWith("_jsp.jsp")) {
			return content;
		}

		int pos = content.indexOf(".sendRedirect(");

		if (pos != -1) {
			addMessage(
				fileName, "Do not use sendRedirect in jsp",
				getLineNumber(content, pos));
		}

		return content;
	}

}