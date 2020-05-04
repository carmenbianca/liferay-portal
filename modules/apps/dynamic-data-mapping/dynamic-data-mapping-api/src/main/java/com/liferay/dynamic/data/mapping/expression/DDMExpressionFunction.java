/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression;

/**
 * @author Leonardo Barros
 */
public interface DDMExpressionFunction {

	public String getName();

	public interface Function0<R> extends DDMExpressionFunction {

		public R apply();

	}

	public interface Function1<A, R> extends DDMExpressionFunction {

		public R apply(A a);

	}

	public interface Function2<A, B, R> extends DDMExpressionFunction {

		public R apply(A a, B b);

	}

	public interface Function3<A, B, C, R> extends DDMExpressionFunction {

		public R apply(A a, B b, C c);

	}

	public interface Function4<A, B, C, D, R> extends DDMExpressionFunction {

		public R apply(A a, B b, C c, D d);

	}

}