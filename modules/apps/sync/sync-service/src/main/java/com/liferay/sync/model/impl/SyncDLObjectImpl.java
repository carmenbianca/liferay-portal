/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.model.impl;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncDLObjectImpl extends SyncDLObjectBaseImpl {

	public SyncDLObjectImpl() {
	}

	@Override
	public String buildTreePath() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreateDate(Date createDate) {
		setCreateTime(createDate.getTime());
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		setModifiedTime(modifiedDate.getTime());
	}

}