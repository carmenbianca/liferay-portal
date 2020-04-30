/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.settings.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.Organization;

import java.util.Set;

import javax.portlet.RenderResponse;

/**
 * @author Geyson Silva
 */
public class OrganizationChecker extends EmptyOnClickRowChecker {

	public OrganizationChecker(RenderResponse renderResponse, Set<String> ids) {
		super(renderResponse);

		setRowIds("syncedOrganizationIds");

		_ids = ids;
	}

	@Override
	public boolean isChecked(Object obj) {
		Organization organization = (Organization)obj;

		return _ids.contains(String.valueOf(organization.getOrganizationId()));
	}

	private final Set<String> _ids;

}