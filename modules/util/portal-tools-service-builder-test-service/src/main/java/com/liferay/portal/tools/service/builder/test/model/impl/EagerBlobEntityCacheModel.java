/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.tools.service.builder.test.model.EagerBlobEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EagerBlobEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EagerBlobEntityCacheModel
	implements CacheModel<EagerBlobEntity>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EagerBlobEntityCacheModel)) {
			return false;
		}

		EagerBlobEntityCacheModel eagerBlobEntityCacheModel =
			(EagerBlobEntityCacheModel)obj;

		if (eagerBlobEntityId == eagerBlobEntityCacheModel.eagerBlobEntityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eagerBlobEntityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eagerBlobEntityId=");
		sb.append(eagerBlobEntityId);
		sb.append(", groupId=");
		sb.append(groupId);

		return sb.toString();
	}

	@Override
	public EagerBlobEntity toEntityModel() {
		EagerBlobEntityImpl eagerBlobEntityImpl = new EagerBlobEntityImpl();

		if (uuid == null) {
			eagerBlobEntityImpl.setUuid("");
		}
		else {
			eagerBlobEntityImpl.setUuid(uuid);
		}

		eagerBlobEntityImpl.setEagerBlobEntityId(eagerBlobEntityId);
		eagerBlobEntityImpl.setGroupId(groupId);

		eagerBlobEntityImpl.resetOriginalValues();

		return eagerBlobEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eagerBlobEntityId = objectInput.readLong();

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

		objectOutput.writeLong(eagerBlobEntityId);

		objectOutput.writeLong(groupId);
	}

	public String uuid;
	public long eagerBlobEntityId;
	public long groupId;

}