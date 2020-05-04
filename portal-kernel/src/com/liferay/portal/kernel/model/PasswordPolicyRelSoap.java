/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PasswordPolicyRelSoap implements Serializable {

	public static PasswordPolicyRelSoap toSoapModel(PasswordPolicyRel model) {
		PasswordPolicyRelSoap soapModel = new PasswordPolicyRelSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setPasswordPolicyRelId(model.getPasswordPolicyRelId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPasswordPolicyId(model.getPasswordPolicyId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());

		return soapModel;
	}

	public static PasswordPolicyRelSoap[] toSoapModels(
		PasswordPolicyRel[] models) {

		PasswordPolicyRelSoap[] soapModels =
			new PasswordPolicyRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PasswordPolicyRelSoap[][] toSoapModels(
		PasswordPolicyRel[][] models) {

		PasswordPolicyRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PasswordPolicyRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PasswordPolicyRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PasswordPolicyRelSoap[] toSoapModels(
		List<PasswordPolicyRel> models) {

		List<PasswordPolicyRelSoap> soapModels =
			new ArrayList<PasswordPolicyRelSoap>(models.size());

		for (PasswordPolicyRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PasswordPolicyRelSoap[soapModels.size()]);
	}

	public PasswordPolicyRelSoap() {
	}

	public long getPrimaryKey() {
		return _passwordPolicyRelId;
	}

	public void setPrimaryKey(long pk) {
		setPasswordPolicyRelId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getPasswordPolicyRelId() {
		return _passwordPolicyRelId;
	}

	public void setPasswordPolicyRelId(long passwordPolicyRelId) {
		_passwordPolicyRelId = passwordPolicyRelId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getPasswordPolicyId() {
		return _passwordPolicyId;
	}

	public void setPasswordPolicyId(long passwordPolicyId) {
		_passwordPolicyId = passwordPolicyId;
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

	private long _mvccVersion;
	private long _passwordPolicyRelId;
	private long _companyId;
	private long _passwordPolicyId;
	private long _classNameId;
	private long _classPK;

}