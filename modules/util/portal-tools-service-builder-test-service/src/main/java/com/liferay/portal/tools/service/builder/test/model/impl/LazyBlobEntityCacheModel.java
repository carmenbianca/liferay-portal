/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LazyBlobEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LazyBlobEntityCacheModel
	implements CacheModel<LazyBlobEntity>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LazyBlobEntityCacheModel)) {
			return false;
		}

		LazyBlobEntityCacheModel lazyBlobEntityCacheModel =
			(LazyBlobEntityCacheModel)obj;

		if (lazyBlobEntityId == lazyBlobEntityCacheModel.lazyBlobEntityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lazyBlobEntityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", lazyBlobEntityId=");
		sb.append(lazyBlobEntityId);
		sb.append(", groupId=");
		sb.append(groupId);

		return sb.toString();
	}

	@Override
	public LazyBlobEntity toEntityModel() {
		LazyBlobEntityImpl lazyBlobEntityImpl = new LazyBlobEntityImpl();

		if (uuid == null) {
			lazyBlobEntityImpl.setUuid("");
		}
		else {
			lazyBlobEntityImpl.setUuid(uuid);
		}

		lazyBlobEntityImpl.setLazyBlobEntityId(lazyBlobEntityId);
		lazyBlobEntityImpl.setGroupId(groupId);

		lazyBlobEntityImpl.resetOriginalValues();

		return lazyBlobEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		lazyBlobEntityId = objectInput.readLong();

		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(lazyBlobEntityId);

		objectOutput.writeLong(groupId);
	}

	public String uuid;
	public long lazyBlobEntityId;
	public long groupId;

}