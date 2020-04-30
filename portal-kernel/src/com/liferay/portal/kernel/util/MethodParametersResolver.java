/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.lang.reflect.Method;

/**
 * @author Igor Spasic
 */
public interface MethodParametersResolver {

	public MethodParameter[] resolveMethodParameters(Method method);

}