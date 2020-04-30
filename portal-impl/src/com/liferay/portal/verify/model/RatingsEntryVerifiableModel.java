/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.verify.model;

import com.liferay.portal.kernel.verify.model.VerifiableUUIDModel;

/**
 * @author Miguel Pastor
 */
public class RatingsEntryVerifiableModel implements VerifiableUUIDModel {

	@Override
	public String getPrimaryKeyColumnName() {
		return "entryId";
	}

	@Override
	public String getTableName() {
		return "RatingsEntry";
	}

}