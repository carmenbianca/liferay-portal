/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model.change.tracking;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;

/**
 * @author Preston Crary
 */
public interface CTModel<T> extends BaseModel<T>, MVCCModel {

	public long getCtCollectionId();

	public long getPrimaryKey();

	public void setCtCollectionId(long ctCollectionId);

	public void setPrimaryKey(long primaryKey);

}