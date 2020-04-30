/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model.version;

/**
 * @author Preston Crary
 */
public interface VersionedModel<V extends VersionModel> {

	public long getHeadId();

	public long getPrimaryKey();

	public default boolean isHead() {
		if (getHeadId() >= 0) {
			return false;
		}

		return true;
	}

	public void populateVersionModel(V versionModel);

	public void setHeadId(long headId);

	public void setPrimaryKey(long primaryKey);

}