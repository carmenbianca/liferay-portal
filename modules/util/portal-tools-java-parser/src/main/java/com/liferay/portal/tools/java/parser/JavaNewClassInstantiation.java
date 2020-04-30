/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaNewClassInstantiation extends BaseJavaExpression {

	public JavaNewClassInstantiation(JavaClassCall javaClassCall) {
		_javaClassCall = javaClassCall;
	}

	public boolean hasBody() {
		return _javaClassCall.hasBody();
	}

	@Override
	protected String getString(
		String indent, String prefix, String suffix, int maxLineLength,
		boolean forceLineBreak) {

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		if (_javaClassCall.hasParameterValueJavaExpressions()) {
			JavaExpression chainedJavaExpression = getChainedJavaExpression();

			if (chainedJavaExpression != null) {
				_javaClassCall.setUseChainStyle(true);

				if (chainedJavaExpression instanceof JavaMethodCall) {
					JavaMethodCall javaMethodCall =
						(JavaMethodCall)chainedJavaExpression;

					javaMethodCall.setUseChainStyle(true);
				}
			}
		}

		if (forceLineBreak) {
			appendWithLineBreak(
				sb, _javaClassCall, indent, prefix + "new ", suffix,
				maxLineLength);
		}
		else {
			append(
				sb, _javaClassCall, indent, prefix + "new ", suffix,
				maxLineLength);
		}

		return sb.toString();
	}

	private final JavaClassCall _javaClassCall;

}