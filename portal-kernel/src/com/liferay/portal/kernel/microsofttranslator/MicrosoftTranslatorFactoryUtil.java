/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.microsofttranslator;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Hugo Huijser
 */
public class MicrosoftTranslatorFactoryUtil {

	public static MicrosoftTranslator getMicrosoftTranslator() {
		return getMicrosoftTranslatorFactory().getMicrosoftTranslator();
	}

	public static MicrosoftTranslatorFactory getMicrosoftTranslatorFactory() {
		return _microsoftTranslatorFactory;
	}

	private static volatile MicrosoftTranslatorFactory
		_microsoftTranslatorFactory =
			ServiceProxyFactory.newServiceTrackedInstance(
				MicrosoftTranslatorFactory.class,
				MicrosoftTranslatorFactoryUtil.class,
				"_microsoftTranslatorFactory", false);

}