/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.web.internal;

import com.liferay.item.selector.BaseItemSelectorCriterion;

/**
 * @author Iván Zaera
 */
public class FlickrItemSelectorCriterion extends BaseItemSelectorCriterion {

	public String[] getTags() {
		return _tags;
	}

	public String getUser() {
		return _user;
	}

	public void setTags(String[] tags) {
		_tags = tags;
	}

	public void setUser(String user) {
		_user = user;
	}

	private String[] _tags = {"me", "photo", "picture"};
	private String _user = "anonymous";

}