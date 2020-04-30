/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.verify.model;

import com.liferay.portal.kernel.model.LayoutSetPrototype;
import com.liferay.portal.kernel.verify.model.VerifiableResourcedModel;

/**
 * @author Miguel Pastor
 */
public class LayoutSetPrototypeVerifiableModel
	implements VerifiableResourcedModel {

	@Override
	public String getModelName() {
		return LayoutSetPrototype.class.getName();
	}

	@Override
	public String getPrimaryKeyColumnName() {
		return "layoutSetPrototypeId";
	}

	@Override
	public String getTableName() {
		return "LayoutSetPrototype";
	}

	@Override
	public String getUserIdColumnName() {
		return "userId";
	}

}