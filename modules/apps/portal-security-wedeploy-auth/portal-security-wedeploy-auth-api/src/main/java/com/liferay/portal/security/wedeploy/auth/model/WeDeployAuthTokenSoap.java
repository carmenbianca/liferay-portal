/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Supritha Sundaram
 * @generated
 */
public class WeDeployAuthTokenSoap implements Serializable {

	public static WeDeployAuthTokenSoap toSoapModel(WeDeployAuthToken model) {
		WeDeployAuthTokenSoap soapModel = new WeDeployAuthTokenSoap();

		soapModel.setWeDeployAuthTokenId(model.getWeDeployAuthTokenId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClientId(model.getClientId());
		soapModel.setToken(model.getToken());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static WeDeployAuthTokenSoap[] toSoapModels(
		WeDeployAuthToken[] models) {

		WeDeployAuthTokenSoap[] soapModels =
			new WeDeployAuthTokenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WeDeployAuthTokenSoap[][] toSoapModels(
		WeDeployAuthToken[][] models) {

		WeDeployAuthTokenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new WeDeployAuthTokenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WeDeployAuthTokenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WeDeployAuthTokenSoap[] toSoapModels(
		List<WeDeployAuthToken> models) {

		List<WeDeployAuthTokenSoap> soapModels =
			new ArrayList<WeDeployAuthTokenSoap>(models.size());

		for (WeDeployAuthToken model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WeDeployAuthTokenSoap[soapModels.size()]);
	}

	public WeDeployAuthTokenSoap() {
	}

	public long getPrimaryKey() {
		return _weDeployAuthTokenId;
	}

	public void setPrimaryKey(long pk) {
		setWeDeployAuthTokenId(pk);
	}

	public long getWeDeployAuthTokenId() {
		return _weDeployAuthTokenId;
	}

	public void setWeDeployAuthTokenId(long weDeployAuthTokenId) {
		_weDeployAuthTokenId = weDeployAuthTokenId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getClientId() {
		return _clientId;
	}

	public void setClientId(String clientId) {
		_clientId = clientId;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private long _weDeployAuthTokenId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _clientId;
	private String _token;
	private int _type;

}