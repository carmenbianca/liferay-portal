/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.organizations.item.selector.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.util.ArrayUtil;

import javax.portlet.RenderResponse;

/**
 * @author Alessio Antonio Rendina
 */
public class OrganizationItemSelectorChecker extends EmptyOnClickRowChecker {

	public OrganizationItemSelectorChecker(
		RenderResponse renderResponse, long[] checkedOrganizationIds) {

		super(renderResponse);

		_checkedOrganizationIds = checkedOrganizationIds;
	}

	@Override
	public boolean isChecked(Object obj) {
		Organization organization = (Organization)obj;

		return ArrayUtil.contains(
			_checkedOrganizationIds, organization.getOrganizationId());
	}

	@Override
	public boolean isDisabled(Object obj) {
		return isChecked(obj);
	}

	private final long[] _checkedOrganizationIds;

}