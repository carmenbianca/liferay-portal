/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.Projection;

/**
 * @author Brian Wing Shun Chan
 */
public class ProjectionImpl implements Projection {

	public ProjectionImpl(org.hibernate.criterion.Projection projection) {
		_projection = projection;
	}

	public org.hibernate.criterion.Projection getWrappedProjection() {
		return _projection;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{_projection=");
		sb.append(String.valueOf(_projection));
		sb.append("}");

		return sb.toString();
	}

	private final org.hibernate.criterion.Projection _projection;

}