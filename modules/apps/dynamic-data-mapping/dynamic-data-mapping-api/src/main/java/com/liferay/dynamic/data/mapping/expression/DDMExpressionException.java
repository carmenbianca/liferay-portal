/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Set;

/**
 * @author Marcellus Tavares
 */
public class DDMExpressionException extends PortalException {

	public DDMExpressionException() {
	}

	public DDMExpressionException(String msg) {
		super(msg);
	}

	public DDMExpressionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DDMExpressionException(Throwable cause) {
		super(cause);
	}

	public static class FunctionNotDefined extends DDMExpressionException {

		public FunctionNotDefined(Set<String> undefinedFunctionNames) {
			super(
				String.format(
					"The functions \"%s\" were not defined",
					StringUtil.merge(undefinedFunctionNames)));

			_undefinedFunctionNames = undefinedFunctionNames;
		}

		public Set<String> getUndefinedFunctionNames() {
			return _undefinedFunctionNames;
		}

		private final Set<String> _undefinedFunctionNames;

	}

	public static class IncompatipleReturnType extends DDMExpressionException {

		public IncompatipleReturnType() {
			super(
				"The evaluation return type differs from DDM Expression type");
		}

	}

	public static class InvalidSyntax extends DDMExpressionException {

		public InvalidSyntax(Throwable cause) {
			super("The expression syntax is invalid", cause);
		}

	}

	public static class NumberExceedsSupportedRange
		extends DDMExpressionException {

		public NumberExceedsSupportedRange() {
			super("The number entered exceeds the supported range");
		}

	}

}