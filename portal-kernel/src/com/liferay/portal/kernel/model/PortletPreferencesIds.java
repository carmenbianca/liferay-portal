/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletPreferencesIds implements Serializable {

	public PortletPreferencesIds(
		long companyId, long ownerId, int ownerType, long plid,
		String portletId) {

		_companyId = companyId;
		_ownerId = ownerId;
		_ownerType = ownerType;
		_plid = plid;
		_portletId = portletId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public int getOwnerType() {
		return _ownerType;
	}

	public long getPlid() {
		return _plid;
	}

	public String getPortletId() {
		return _portletId;
	}

	private final long _companyId;
	private final long _ownerId;
	private final int _ownerType;
	private final long _plid;
	private final String _portletId;

}