/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.request.builder;

import com.liferay.digital.signature.request.VoidPackageDSSignatureRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface VoidPackageDSSignatureRequestBuilder {

	public VoidPackageDSSignatureRequest getVoidPackageDSSignatureRequest();

	public VoidPackageDSSignatureRequestBuilder setDSSignaturePackageKey(
		String dsSignaturePackageKey);

	public VoidPackageDSSignatureRequestBuilder setExternalReferenceKey(
		String externalReferenceKey);

	public VoidPackageDSSignatureRequestBuilder setVoidReason(
		String voidReason);

}