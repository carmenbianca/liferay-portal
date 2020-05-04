/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.simplecaptcha;

import com.liferay.portal.kernel.util.PwdGenerator;

import nl.captcha.text.producer.TextProducer;

/**
 * @author Brian Wing Shun Chan
 */
public class PinNumberTextProducer implements TextProducer {

	@Override
	public String getText() {
		return PwdGenerator.getPinNumber();
	}

}