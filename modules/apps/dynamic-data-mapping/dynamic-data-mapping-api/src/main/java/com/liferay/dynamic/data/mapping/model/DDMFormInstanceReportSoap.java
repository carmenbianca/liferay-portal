/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DDMFormInstanceReportSoap implements Serializable {

	public static DDMFormInstanceReportSoap toSoapModel(
		DDMFormInstanceReport model) {

		DDMFormInstanceReportSoap soapModel = new DDMFormInstanceReportSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setFormInstanceReportId(model.getFormInstanceReportId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFormInstanceId(model.getFormInstanceId());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static DDMFormInstanceReportSoap[] toSoapModels(
		DDMFormInstanceReport[] models) {

		DDMFormInstanceReportSoap[] soapModels =
			new DDMFormInstanceReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DDMFormInstanceReportSoap[][] toSoapModels(
		DDMFormInstanceReport[][] models) {

		DDMFormInstanceReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DDMFormInstanceReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DDMFormInstanceReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DDMFormInstanceReportSoap[] toSoapModels(
		List<DDMFormInstanceReport> models) {

		List<DDMFormInstanceReportSoap> soapModels =
			new ArrayList<DDMFormInstanceReportSoap>(models.size());

		for (DDMFormInstanceReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DDMFormInstanceReportSoap[soapModels.size()]);
	}

	public DDMFormInstanceReportSoap() {
	}

	public long getPrimaryKey() {
		return _formInstanceReportId;
	}

	public void setPrimaryKey(long pk) {
		setFormInstanceReportId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getFormInstanceReportId() {
		return _formInstanceReportId;
	}

	public void setFormInstanceReportId(long formInstanceReportId) {
		_formInstanceReportId = formInstanceReportId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getFormInstanceId() {
		return _formInstanceId;
	}

	public void setFormInstanceId(long formInstanceId) {
		_formInstanceId = formInstanceId;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _mvccVersion;
	private long _formInstanceReportId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _formInstanceId;
	private String _data;

}