/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.verify.model;

/**
 * @author Miguel Pastor
 */
public interface VerifiableResourcedModel extends VerifiableModel {

	public String getModelName();

	@Override
	public String getPrimaryKeyColumnName();

	@Override
	public String getTableName();

	public String getUserIdColumnName();

}