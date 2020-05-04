/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.util;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;
import com.liferay.portal.kernel.cache.key.CacheKeyGeneratorUtil;
import com.liferay.portal.kernel.util.Digester;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.registry.collections.ServiceTrackerCollections;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Miguel Pastor
 * @author Carlos Sierra Andrés
 */
public class CacheFileNameGenerator {

	public static String getCacheFileName(
		HttpServletRequest httpServletRequest, String cacheName) {

		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(cacheName);

		cacheKeyGenerator.append(
			HttpUtil.getProtocol(httpServletRequest.isSecure()));
		cacheKeyGenerator.append(StringPool.UNDERLINE);
		cacheKeyGenerator.append(httpServletRequest.getRequestURI());

		StringBundler queryStringSB = new StringBundler(
			_cacheFileNameContributors.size() * 4);

		for (CacheFileNameContributor cacheFileNameContributor :
				_cacheFileNameContributors) {

			String value = cacheFileNameContributor.getParameterValue(
				httpServletRequest);

			if (value == null) {
				continue;
			}

			queryStringSB.append(StringPool.UNDERLINE);
			queryStringSB.append(cacheFileNameContributor.getParameterName());
			queryStringSB.append(StringPool.UNDERLINE);
			queryStringSB.append(value);
		}

		cacheKeyGenerator.append(
			DigesterUtil.digestBase64(
				Digester.SHA_256, queryStringSB.toString()));

		return _sterilizeFileName(String.valueOf(cacheKeyGenerator.finish()));
	}

	private static String _sterilizeFileName(String fileName) {
		return StringUtil.replace(
			fileName,
			new char[] {
				CharPool.SLASH, CharPool.BACK_SLASH, CharPool.PLUS,
				CharPool.EQUAL
			},
			new char[] {
				CharPool.UNDERLINE, CharPool.UNDERLINE, CharPool.DASH,
				CharPool.UNDERLINE
			});
	}

	private static final List<CacheFileNameContributor>
		_cacheFileNameContributors = ServiceTrackerCollections.openList(
			CacheFileNameContributor.class);

}