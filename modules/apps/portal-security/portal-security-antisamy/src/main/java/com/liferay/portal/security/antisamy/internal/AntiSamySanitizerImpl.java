/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.antisamy.internal;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.sanitizer.Sanitizer;
import com.liferay.portal.kernel.sanitizer.SanitizerException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;

/**
 * @author Zsolt Balogh
 * @author Brian Wing Shun Chan
 */
public class AntiSamySanitizerImpl implements Sanitizer {

	public AntiSamySanitizerImpl(
		String[] blacklist, URL url, String[] whitelist) {

		try (InputStream inputstream = url.openStream()) {
			_policy = Policy.getInstance(inputstream);
		}
		catch (Exception exception) {
			throw new IllegalStateException(
				"Unable to initialize policy", exception);
		}

		if (blacklist != null) {
			for (String blacklistItem : blacklist) {
				blacklistItem = blacklistItem.trim();

				if (!blacklistItem.isEmpty()) {
					blacklistItem = stripTrailingStar(blacklistItem);

					_blacklist.add(blacklistItem);
				}
			}
		}

		if (whitelist != null) {
			for (String whitelistItem : whitelist) {
				whitelistItem = whitelistItem.trim();

				if (!whitelistItem.isEmpty()) {
					whitelistItem = stripTrailingStar(whitelistItem);

					_whitelist.add(whitelistItem);
				}
			}
		}
	}

	@Override
	public String sanitize(
			long companyId, long groupId, long userId, String className,
			long classPK, String contentType, String[] modes, String content,
			Map<String, Object> options)
		throws SanitizerException {

		if (_log.isDebugEnabled()) {
			_log.debug(
				StringBundler.concat("Sanitizing ", className, "#", classPK));
		}

		if (Validator.isNull(content)) {
			return content;
		}

		if (Validator.isNull(contentType) ||
			!contentType.equals(ContentTypes.TEXT_HTML)) {

			return content;
		}

		if (isWhitelisted(className, classPK)) {
			return content;
		}

		try {
			AntiSamy antiSamy = new AntiSamy();

			CleanResults cleanResults = antiSamy.scan(content, _policy);

			return cleanResults.getCleanHTML();
		}
		catch (Exception exception) {
			_log.error("Unable to sanitize input", exception);

			throw new SanitizerException(exception);
		}
	}

	protected boolean isWhitelisted(String className, long classPK) {
		String classNameAndClassPK = className + StringPool.POUND + classPK;

		for (String blacklistItem : _blacklist) {
			if (blacklistItem.equals(StringPool.STAR) ||
				classNameAndClassPK.startsWith(blacklistItem)) {

				return false;
			}
		}

		for (String whitelistItem : _whitelist) {
			if (whitelistItem.equals(StringPool.STAR) ||
				classNameAndClassPK.startsWith(whitelistItem)) {

				return true;
			}
		}

		return false;
	}

	protected String stripTrailingStar(String item) {
		if (item.equals(StringPool.STAR)) {
			return item;
		}

		char c = item.charAt(item.length() - 1);

		if (c == CharPool.STAR) {
			return item.substring(0, item.length() - 1);
		}

		return item;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AntiSamySanitizerImpl.class);

	private final List<String> _blacklist = new ArrayList<>();
	private final Policy _policy;
	private final List<String> _whitelist = new ArrayList<>();

}