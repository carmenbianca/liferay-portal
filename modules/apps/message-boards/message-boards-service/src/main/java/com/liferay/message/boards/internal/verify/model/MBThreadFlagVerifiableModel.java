/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.verify.model;

import com.liferay.portal.kernel.verify.model.VerifiableGroupedModel;

/**
 * @author Miguel Pastor
 */
public class MBThreadFlagVerifiableModel implements VerifiableGroupedModel {

	@Override
	public String getPrimaryKeyColumnName() {
		return "threadFlagId";
	}

	@Override
	public String getRelatedPrimaryKeyColumnName() {
		return "threadId";
	}

	@Override
	public String getRelatedTableName() {
		return "MBThread";
	}

	@Override
	public String getTableName() {
		return "MBThreadFlag";
	}

}