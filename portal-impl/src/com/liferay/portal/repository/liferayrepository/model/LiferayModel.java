/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.liferayrepository.model;

import com.liferay.expando.kernel.model.ExpandoBridge;

/**
 * @author Alexander Chow
 */
public abstract class LiferayModel {

	public abstract long getCompanyId();

	public abstract ExpandoBridge getExpandoBridge();

	public abstract String getModelClassName();

	public abstract long getPrimaryKey();

}