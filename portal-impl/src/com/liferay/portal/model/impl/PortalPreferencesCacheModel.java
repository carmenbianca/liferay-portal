/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.PortalPreferences;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PortalPreferences in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PortalPreferencesCacheModel
	implements CacheModel<PortalPreferences>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortalPreferencesCacheModel)) {
			return false;
		}

		PortalPreferencesCacheModel portalPreferencesCacheModel =
			(PortalPreferencesCacheModel)obj;

		if ((portalPreferencesId ==
				portalPreferencesCacheModel.portalPreferencesId) &&
			(mvccVersion == portalPreferencesCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, portalPreferencesId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", portalPreferencesId=");
		sb.append(portalPreferencesId);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", ownerType=");
		sb.append(ownerType);
		sb.append(", preferences=");
		sb.append(preferences);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PortalPreferences toEntityModel() {
		PortalPreferencesImpl portalPreferencesImpl =
			new PortalPreferencesImpl();

		portalPreferencesImpl.setMvccVersion(mvccVersion);
		portalPreferencesImpl.setPortalPreferencesId(portalPreferencesId);
		portalPreferencesImpl.setOwnerId(ownerId);
		portalPreferencesImpl.setOwnerType(ownerType);

		if (preferences == null) {
			portalPreferencesImpl.setPreferences("");
		}
		else {
			portalPreferencesImpl.setPreferences(preferences);
		}

		portalPreferencesImpl.resetOriginalValues();

		return portalPreferencesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();

		portalPreferencesId = objectInput.readLong();

		ownerId = objectInput.readLong();

		ownerType = objectInput.readInt();
		preferences = (String)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(portalPreferencesId);

		objectOutput.writeLong(ownerId);

		objectOutput.writeInt(ownerType);

		if (preferences == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(preferences);
		}
	}

	public long mvccVersion;
	public long portalPreferencesId;
	public long ownerId;
	public int ownerType;
	public String preferences;

}