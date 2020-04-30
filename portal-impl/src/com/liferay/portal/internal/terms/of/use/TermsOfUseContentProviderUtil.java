/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.internal.terms.of.use;

import com.liferay.portal.kernel.terms.of.use.TermsOfUseContentProvider;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Eduardo García
 */
public class TermsOfUseContentProviderUtil {

	public static TermsOfUseContentProvider getTermsOfUseContentProvider() {
		return _termsOfUseContentProvider;
	}

	private static volatile TermsOfUseContentProvider
		_termsOfUseContentProvider =
			ServiceProxyFactory.newServiceTrackedInstance(
				TermsOfUseContentProvider.class,
				TermsOfUseContentProviderUtil.class,
				"_termsOfUseContentProvider", false, true);

}