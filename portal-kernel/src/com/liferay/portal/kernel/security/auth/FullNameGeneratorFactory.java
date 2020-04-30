/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public class FullNameGeneratorFactory {

	public static FullNameGenerator getInstance() {
		return _fullNameGenerator;
	}

	public void setFullNameGenerator(FullNameGenerator fullNameGenerator) {
		_fullNameGenerator = fullNameGenerator;
	}

	private FullNameGeneratorFactory() {
	}

	private static volatile FullNameGenerator _fullNameGenerator =
		ServiceProxyFactory.newServiceTrackedInstance(
			FullNameGenerator.class, FullNameGeneratorFactory.class,
			"_fullNameGenerator", true);

}