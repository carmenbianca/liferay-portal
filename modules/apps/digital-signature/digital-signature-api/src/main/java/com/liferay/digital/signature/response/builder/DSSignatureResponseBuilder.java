/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.response.builder;

import com.liferay.digital.signature.common.DSSignaturePackageStatus;
import com.liferay.digital.signature.response.DSSignatureResponse;

import java.time.ZonedDateTime;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSSignatureResponseBuilder {

	public DSSignatureResponse getDSSignatureResponse();

	public DSSignatureResponseBuilder setDSSignatureRequestStatus(
		DSSignaturePackageStatus dsSignaturePackageStatus);

	public DSSignatureResponseBuilder setErrorCode(String errorCode);

	public DSSignatureResponseBuilder setErrorDebugMessage(
		String errorDebugMessage);

	public DSSignatureResponseBuilder setErrorMessage(String errorMessage);

	public DSSignatureResponseBuilder setExternalReferenceKey(
		String externalReferenceKey);

	public DSSignatureResponseBuilder setExternalReferenceURI(
		String externalReferenceURI);

	public DSSignatureResponseBuilder setTimestampZonedDateTime(
		ZonedDateTime timestampZonedDateTime);

}