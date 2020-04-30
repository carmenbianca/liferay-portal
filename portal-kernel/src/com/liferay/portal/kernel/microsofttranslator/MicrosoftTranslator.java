/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.microsofttranslator;

/**
 * @author Hugo Huijser
 */
public interface MicrosoftTranslator {

	public String translate(
			String fromLanguageId, String toLanguageId, String fromText)
		throws MicrosoftTranslatorException;

}