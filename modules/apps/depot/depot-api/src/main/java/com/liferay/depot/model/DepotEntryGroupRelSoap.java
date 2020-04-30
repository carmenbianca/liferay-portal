/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.depot.service.http.DepotEntryGroupRelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DepotEntryGroupRelSoap implements Serializable {

	public static DepotEntryGroupRelSoap toSoapModel(DepotEntryGroupRel model) {
		DepotEntryGroupRelSoap soapModel = new DepotEntryGroupRelSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setDepotEntryGroupRelId(model.getDepotEntryGroupRelId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setDepotEntryId(model.getDepotEntryId());
		soapModel.setSearchable(model.isSearchable());
		soapModel.setToGroupId(model.getToGroupId());

		return soapModel;
	}

	public static DepotEntryGroupRelSoap[] toSoapModels(
		DepotEntryGroupRel[] models) {

		DepotEntryGroupRelSoap[] soapModels =
			new DepotEntryGroupRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DepotEntryGroupRelSoap[][] toSoapModels(
		DepotEntryGroupRel[][] models) {

		DepotEntryGroupRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DepotEntryGroupRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DepotEntryGroupRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DepotEntryGroupRelSoap[] toSoapModels(
		List<DepotEntryGroupRel> models) {

		List<DepotEntryGroupRelSoap> soapModels =
			new ArrayList<DepotEntryGroupRelSoap>(models.size());

		for (DepotEntryGroupRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DepotEntryGroupRelSoap[soapModels.size()]);
	}

	public DepotEntryGroupRelSoap() {
	}

	public long getPrimaryKey() {
		return _depotEntryGroupRelId;
	}

	public void setPrimaryKey(long pk) {
		setDepotEntryGroupRelId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getDepotEntryGroupRelId() {
		return _depotEntryGroupRelId;
	}

	public void setDepotEntryGroupRelId(long depotEntryGroupRelId) {
		_depotEntryGroupRelId = depotEntryGroupRelId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getDepotEntryId() {
		return _depotEntryId;
	}

	public void setDepotEntryId(long depotEntryId) {
		_depotEntryId = depotEntryId;
	}

	public boolean getSearchable() {
		return _searchable;
	}

	public boolean isSearchable() {
		return _searchable;
	}

	public void setSearchable(boolean searchable) {
		_searchable = searchable;
	}

	public long getToGroupId() {
		return _toGroupId;
	}

	public void setToGroupId(long toGroupId) {
		_toGroupId = toGroupId;
	}

	private long _mvccVersion;
	private long _depotEntryGroupRelId;
	private long _companyId;
	private long _depotEntryId;
	private boolean _searchable;
	private long _toGroupId;

}