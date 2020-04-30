/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.internal.data;

import com.google.template.soy.data.SanitizedContent;
import com.google.template.soy.data.UnsafeSanitizedContentOrdainer;

import com.liferay.portal.template.soy.util.SoyRawData;

/**
 * @author Tina Tian
 */
public class SoyRawDataImpl implements SoyRawData {

	public SoyRawDataImpl(String html) {
		_sanitizedContent = UnsafeSanitizedContentOrdainer.ordainAsSafe(
			html, SanitizedContent.ContentKind.HTML);
	}

	@Override
	public Object getValue() {
		return _sanitizedContent;
	}

	private final SanitizedContent _sanitizedContent;

}