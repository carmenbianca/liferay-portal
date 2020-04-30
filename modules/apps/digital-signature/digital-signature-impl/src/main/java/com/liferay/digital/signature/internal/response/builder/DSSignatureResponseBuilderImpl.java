/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.response.builder;

import com.liferay.digital.signature.common.DSSignaturePackageStatus;
import com.liferay.digital.signature.internal.response.DSSignatureResponseImpl;
import com.liferay.digital.signature.response.DSSignatureResponse;
import com.liferay.digital.signature.response.builder.DSSignatureResponseBuilder;

import java.time.ZonedDateTime;

/**
 * @author Michael C. Han
 */
public class DSSignatureResponseBuilderImpl
	implements DSSignatureResponseBuilder {

	public DSSignatureResponseBuilderImpl(String dsSignatureRequestKey) {
		_dsSignatureRequestKey = dsSignatureRequestKey;
	}

	@Override
	public DSSignatureResponse getDSSignatureResponse() {
		return new DSSignatureResponseImpl(
			_dsSignatureRequestKey, _externalReferenceKey) {

			{
				setDSSignatureRequestStatus(_dsSignaturePackageStatus);
				setErrorCode(_errorCode);
				setErrorDebugMessage(_errorDebugMessage);
				setErrorMessage(_errorMessage);
				setExternalReferenceURI(_externalReferenceURI);
				setTimestampZonedDateTime(_timestampZonedDateTime);
			}
		};
	}

	@Override
	public DSSignatureResponseBuilder setDSSignatureRequestStatus(
		DSSignaturePackageStatus dsSignaturePackageStatus) {

		_dsSignaturePackageStatus = dsSignaturePackageStatus;

		return this;
	}

	@Override
	public DSSignatureResponseBuilder setErrorCode(String errorCode) {
		_errorCode = errorCode;

		return this;
	}

	@Override
	public DSSignatureResponseBuilder setErrorDebugMessage(
		String errorDebugMessage) {

		_errorDebugMessage = errorDebugMessage;

		return this;
	}

	@Override
	public DSSignatureResponseBuilder setErrorMessage(String errorMessage) {
		_errorMessage = errorMessage;

		return this;
	}

	@Override
	public DSSignatureResponseBuilder setExternalReferenceKey(
		String externalReferenceKey) {

		_externalReferenceKey = externalReferenceKey;

		return this;
	}

	@Override
	public DSSignatureResponseBuilder setExternalReferenceURI(
		String externalReferenceURI) {

		_externalReferenceURI = externalReferenceURI;

		return this;
	}

	@Override
	public DSSignatureResponseBuilder setTimestampZonedDateTime(
		ZonedDateTime timestampZonedDateTime) {

		_timestampZonedDateTime = timestampZonedDateTime;

		return this;
	}

	private DSSignaturePackageStatus _dsSignaturePackageStatus;
	private final String _dsSignatureRequestKey;
	private String _errorCode;
	private String _errorDebugMessage;
	private String _errorMessage;
	private String _externalReferenceKey;
	private String _externalReferenceURI;
	private ZonedDateTime _timestampZonedDateTime;

}