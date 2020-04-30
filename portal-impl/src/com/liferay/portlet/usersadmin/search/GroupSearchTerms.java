/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.usersadmin.search;

import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class GroupSearchTerms extends GroupDisplayTerms {

	public GroupSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
	}

	public boolean hasSearchTerms() {
		if (isAdvancedSearch()) {
			if (Validator.isNotNull(name) || Validator.isNotNull(description)) {
				return true;
			}
		}
		else {
			if (Validator.isNotNull(keywords)) {
				return true;
			}
		}

		return false;
	}

}