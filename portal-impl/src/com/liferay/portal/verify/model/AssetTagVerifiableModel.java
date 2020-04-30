/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.verify.model;

import com.liferay.portal.kernel.verify.model.VerifiableUUIDModel;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetTagVerifiableModel implements VerifiableUUIDModel {

	@Override
	public String getPrimaryKeyColumnName() {
		return "tagId";
	}

	@Override
	public String getTableName() {
		return "AssetTag";
	}

}