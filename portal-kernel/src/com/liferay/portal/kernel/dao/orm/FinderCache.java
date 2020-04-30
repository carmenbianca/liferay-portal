/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 */
public interface FinderCache {

	public void clearCache();

	public void clearCache(String className);

	public void clearLocalCache();

	public Object getResult(
		FinderPath finderPath, Object[] args,
		BasePersistenceImpl<? extends BaseModel<?>> basePersistenceImpl);

	public void invalidate();

	public void putResult(FinderPath finderPath, Object[] args, Object result);

	public void putResult(
		FinderPath finderPath, Object[] args, Object result, boolean quiet);

	public void removeCache(String className);

	public void removeResult(FinderPath finderPath, Object[] args);

}