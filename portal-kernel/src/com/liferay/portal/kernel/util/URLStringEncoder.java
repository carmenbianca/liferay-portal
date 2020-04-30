/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Connor McKay
 */
public class URLStringEncoder implements StringEncoder {

	@Override
	public String decode(String s) {
		return HttpUtil.decodeURL(s);
	}

	@Override
	public String encode(String s) {
		return URLCodec.encodeURL(s);
	}

}