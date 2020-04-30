/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webcache;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface WebCacheItem extends Serializable {

	public Object convert(String key) throws WebCacheException;

	public long getRefreshTime();

}