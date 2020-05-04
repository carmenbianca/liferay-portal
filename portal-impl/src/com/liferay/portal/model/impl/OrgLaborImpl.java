/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class OrgLaborImpl extends OrgLaborBaseImpl {

	@Override
	public ListType getType() throws PortalException {
		return ListTypeServiceUtil.getListType(getTypeId());
	}

}