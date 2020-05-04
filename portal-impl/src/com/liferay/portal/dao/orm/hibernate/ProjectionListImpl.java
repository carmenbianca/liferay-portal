/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionList;

/**
 * @author Brian Wing Shun Chan
 */
public class ProjectionListImpl
	extends ProjectionImpl implements ProjectionList {

	public ProjectionListImpl(
		org.hibernate.criterion.ProjectionList projectionList) {

		super(projectionList);

		_projectionList = projectionList;
	}

	@Override
	public ProjectionList add(Projection projection) {
		ProjectionImpl projectionImpl = (ProjectionImpl)projection;

		_projectionList.add(projectionImpl.getWrappedProjection());

		return this;
	}

	@Override
	public ProjectionList add(Projection projection, String alias) {
		ProjectionImpl projectionImpl = (ProjectionImpl)projection;

		_projectionList.add(projectionImpl.getWrappedProjection(), alias);

		return this;
	}

	public org.hibernate.criterion.ProjectionList getWrappedProjectionList() {
		return _projectionList;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{_projectionList=");
		sb.append(String.valueOf(_projectionList));
		sb.append("}");

		return sb.toString();
	}

	private final org.hibernate.criterion.ProjectionList _projectionList;

}