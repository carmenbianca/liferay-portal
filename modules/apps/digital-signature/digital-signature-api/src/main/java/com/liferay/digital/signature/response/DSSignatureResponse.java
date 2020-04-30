/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.response;

import com.liferay.digital.signature.common.DSSignaturePackageStatus;

import java.time.ZonedDateTime;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSSignatureResponse {

	public String getDSSignatureRequestKey();

	public DSSignaturePackageStatus getDSSignatureRequestStatus();

	public String getErrorCode();

	public String getErrorDebugMessage();

	public String getErrorMessage();

	public String getExternalReferenceKey();

	public String getExternalReferenceURI();

	public ZonedDateTime getTimestampZonedDateTime();

}