/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.test.randomizerbumpers;

import com.liferay.portal.kernel.parsers.bbcode.BBCodeTranslatorUtil;
import com.liferay.portal.kernel.test.randomizerbumpers.RandomizerBumper;

/**
 * @author Shuyang Zhou
 */
public class BBCodeRandomizerBumper implements RandomizerBumper<String> {

	public static final BBCodeRandomizerBumper INSTANCE =
		new BBCodeRandomizerBumper();

	@Override
	public boolean accept(String randomValue) {
		if (randomValue.equals(BBCodeTranslatorUtil.getHTML(randomValue))) {
			return true;
		}

		return false;
	}

}