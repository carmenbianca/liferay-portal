/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author Shuyang Zhou
 */
public class TransientTokenUtil {

	public static boolean checkToken(String token) {
		long currentTime = System.currentTimeMillis();

		_expungeExpiredToken(currentTime);

		Set<Map.Entry<Long, String>> tokens = _tokens.entrySet();

		Iterator<Map.Entry<Long, String>> itr = tokens.iterator();

		while (itr.hasNext()) {
			Map.Entry<Long, String> entry = itr.next();

			String curToken = entry.getValue();

			if (token.equals(curToken)) {
				itr.remove();

				return true;
			}
		}

		return false;
	}

	public static void clearAll() {
		_tokens.clear();
	}

	public static String createToken(long timeTolive) {
		long currentTime = System.currentTimeMillis();

		long expireTime = currentTime + timeTolive;

		_expungeExpiredToken(currentTime);

		String token = PortalUUIDUtil.generate();

		while (_tokens.putIfAbsent(expireTime, token) != null) {
			expireTime++;
		}

		return token;
	}

	private static void _expungeExpiredToken(long currentTime) {
		SortedMap<Long, String> headMap = _tokens.headMap(currentTime);

		headMap.clear();
	}

	private static final ConcurrentNavigableMap<Long, String> _tokens =
		new ConcurrentSkipListMap<>();

}