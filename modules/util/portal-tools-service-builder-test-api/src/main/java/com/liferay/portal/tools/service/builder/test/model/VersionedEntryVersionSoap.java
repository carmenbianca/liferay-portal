/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VersionedEntryVersionSoap implements Serializable {

	public static VersionedEntryVersionSoap toSoapModel(
		VersionedEntryVersion model) {

		VersionedEntryVersionSoap soapModel = new VersionedEntryVersionSoap();

		soapModel.setVersionedEntryVersionId(
			model.getVersionedEntryVersionId());
		soapModel.setVersion(model.getVersion());
		soapModel.setVersionedEntryId(model.getVersionedEntryId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static VersionedEntryVersionSoap[] toSoapModels(
		VersionedEntryVersion[] models) {

		VersionedEntryVersionSoap[] soapModels =
			new VersionedEntryVersionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VersionedEntryVersionSoap[][] toSoapModels(
		VersionedEntryVersion[][] models) {

		VersionedEntryVersionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new VersionedEntryVersionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VersionedEntryVersionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VersionedEntryVersionSoap[] toSoapModels(
		List<VersionedEntryVersion> models) {

		List<VersionedEntryVersionSoap> soapModels =
			new ArrayList<VersionedEntryVersionSoap>(models.size());

		for (VersionedEntryVersion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new VersionedEntryVersionSoap[soapModels.size()]);
	}

	public VersionedEntryVersionSoap() {
	}

	public long getPrimaryKey() {
		return _versionedEntryVersionId;
	}

	public void setPrimaryKey(long pk) {
		setVersionedEntryVersionId(pk);
	}

	public long getVersionedEntryVersionId() {
		return _versionedEntryVersionId;
	}

	public void setVersionedEntryVersionId(long versionedEntryVersionId) {
		_versionedEntryVersionId = versionedEntryVersionId;
	}

	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_version = version;
	}

	public long getVersionedEntryId() {
		return _versionedEntryId;
	}

	public void setVersionedEntryId(long versionedEntryId) {
		_versionedEntryId = versionedEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _versionedEntryVersionId;
	private int _version;
	private long _versionedEntryId;
	private long _groupId;

}