/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.reading.time.service.http.ReadingTimeEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReadingTimeEntrySoap implements Serializable {

	public static ReadingTimeEntrySoap toSoapModel(ReadingTimeEntry model) {
		ReadingTimeEntrySoap soapModel = new ReadingTimeEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setReadingTimeEntryId(model.getReadingTimeEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setReadingTime(model.getReadingTime());

		return soapModel;
	}

	public static ReadingTimeEntrySoap[] toSoapModels(
		ReadingTimeEntry[] models) {

		ReadingTimeEntrySoap[] soapModels =
			new ReadingTimeEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReadingTimeEntrySoap[][] toSoapModels(
		ReadingTimeEntry[][] models) {

		ReadingTimeEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ReadingTimeEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReadingTimeEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReadingTimeEntrySoap[] toSoapModels(
		List<ReadingTimeEntry> models) {

		List<ReadingTimeEntrySoap> soapModels =
			new ArrayList<ReadingTimeEntrySoap>(models.size());

		for (ReadingTimeEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReadingTimeEntrySoap[soapModels.size()]);
	}

	public ReadingTimeEntrySoap() {
	}

	public long getPrimaryKey() {
		return _readingTimeEntryId;
	}

	public void setPrimaryKey(long pk) {
		setReadingTimeEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getReadingTimeEntryId() {
		return _readingTimeEntryId;
	}

	public void setReadingTimeEntryId(long readingTimeEntryId) {
		_readingTimeEntryId = readingTimeEntryId;
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

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getReadingTime() {
		return _readingTime;
	}

	public void setReadingTime(long readingTime) {
		_readingTime = readingTime;
	}

	private String _uuid;
	private long _readingTimeEntryId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _readingTime;

}