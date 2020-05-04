/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.model.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class OAuth2ScopeGrantImpl extends OAuth2ScopeGrantBaseImpl {

	@Override
	public List<String> getScopeAliasesList() {
		return Arrays.asList(
			StringUtil.split(getScopeAliases(), StringPool.SPACE));
	}

	@Override
	public void setScopeAliases(String scopeAliases) {
		setScopeAliasesList(
			ListUtil.fromString(scopeAliases, StringPool.SPACE));
	}

	@Override
	public void setScopeAliasesList(List<String> scopeAliasesList) {
		String scopeAliases = StringUtil.merge(
			ListUtil.sort(
				ListUtil.filter(scopeAliasesList, Validator::isNotNull)),
			StringPool.SPACE);

		super.setScopeAliases(scopeAliases);
	}

}