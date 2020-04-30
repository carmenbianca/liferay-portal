/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.model.impl;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Michael Young
 */
public class OAuthConsumerImpl extends OAuthConsumerBaseImpl {

	public OAuthConsumerImpl() {
	}

	@Override
	public String getKeyName() {
		return GetterUtil.getString(_keyName);
	}

	@Override
	public void setKeyName(String keyName) {
		_keyName = keyName;
	}

	private String _keyName;

}