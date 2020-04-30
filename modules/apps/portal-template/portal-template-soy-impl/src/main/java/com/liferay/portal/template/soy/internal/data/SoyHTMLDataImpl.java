/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.internal.data;

import com.google.template.soy.data.SanitizedContent;
import com.google.template.soy.data.UnsafeSanitizedContentOrdainer;

import com.liferay.portal.template.soy.data.SoyHTMLData;

/**
 * @author     Iván Zaera Avellón
 * @deprecated As of Mueller (7.2.x), replaced by {@link SoyRawDataImpl}
 */
@Deprecated
public class SoyHTMLDataImpl implements SoyHTMLData {

	public SoyHTMLDataImpl(String html) {
		_sanitizedContent = UnsafeSanitizedContentOrdainer.ordainAsSafe(
			html, SanitizedContent.ContentKind.HTML);
	}

	@Override
	public Object getValue() {
		return _sanitizedContent;
	}

	private final SanitizedContent _sanitizedContent;

}