/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Peter Shin
 */
public class CDNCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return _fixCDNURL(content);
	}

	private String _fixCDNURL(String content) {
		return StringUtil.replace(
			content,
			new String[] {
				"cdn.lfrs.sl/releases.liferay.com",
				"cdn.lfrs.sl/repository.liferay.com",
				"repository.liferay.com/nexus/content/repositories/",
				"repository.liferay.com/nexus/service/local/repo_groups" +
					"/private/content/"
			},
			new String[] {
				"releases-cdn.liferay.com", "repository-cdn.liferay.com",
				"repository-cdn.liferay.com/nexus/content/repositories/",
				"repository-cdn.liferay.com/nexus/service/local/repo_groups" +
					"/private/content/"
			});
	}

}