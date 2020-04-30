/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.request.builder;

import com.liferay.digital.signature.common.DSSignaturePackageStatus;
import com.liferay.digital.signature.internal.request.CreatePackageDSSignatureRequestImpl;
import com.liferay.digital.signature.model.DSSessionKey;
import com.liferay.digital.signature.model.DSSignaturePackage;
import com.liferay.digital.signature.request.CreatePackageDSSignatureRequest;
import com.liferay.digital.signature.request.builder.CreatePackageDSSignatureRequestBuilder;

/**
 * @author Michael C. Han
 */
public class CreatePackageDSSignatureRequestBuilderImpl
	implements CreatePackageDSSignatureRequestBuilder {

	public CreatePackageDSSignatureRequestBuilderImpl(
		DSSessionKey dsSessionKey) {

		_dsSessionKey = dsSessionKey;
	}

	@Override
	public CreatePackageDSSignatureRequest
		getDraftCreatePackageDSSignatureRequest() {

		return new CreatePackageDSSignatureRequestImpl(
			_dsSessionKey, _dsSignaturePackage,
			DSSignaturePackageStatus.CREATED);
	}

	@Override
	public CreatePackageDSSignatureRequest
		getSentCreatePackageDSSignatureRequest() {

		return new CreatePackageDSSignatureRequestImpl(
			_dsSessionKey, _dsSignaturePackage, DSSignaturePackageStatus.SENT);
	}

	@Override
	public CreatePackageDSSignatureRequestBuilder setDSSignaturePackage(
		DSSignaturePackage dsSignaturePackage) {

		_dsSignaturePackage = dsSignaturePackage;

		return this;
	}

	private final DSSessionKey _dsSessionKey;
	private DSSignaturePackage _dsSignaturePackage;

}