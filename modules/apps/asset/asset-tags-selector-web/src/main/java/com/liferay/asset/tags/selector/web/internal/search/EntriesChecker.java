/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.selector.web.internal.search;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
public class EntriesChecker extends EmptyOnClickRowChecker {

	public EntriesChecker(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		super(portletResponse);

		_portletRequest = portletRequest;
	}

	@Override
	public boolean isChecked(Object obj) {
		String[] selectedTagNames = StringUtil.split(
			ParamUtil.getString(_portletRequest, "selectedTagNames"));

		if (ArrayUtil.isEmpty(selectedTagNames)) {
			return false;
		}

		AssetTag tag = (AssetTag)obj;

		if (!ArrayUtil.contains(selectedTagNames, tag.getName())) {
			return false;
		}

		return true;
	}

	private final PortletRequest _portletRequest;

}