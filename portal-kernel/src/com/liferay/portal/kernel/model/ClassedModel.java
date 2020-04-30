/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.expando.kernel.model.ExpandoBridge;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface ClassedModel {

	public ExpandoBridge getExpandoBridge();

	public Class<?> getModelClass();

	public String getModelClassName();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

}