/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.request;

import com.liferay.digital.signature.common.DSSignaturePackageStatus;
import com.liferay.digital.signature.model.DSSessionKey;
import com.liferay.digital.signature.model.DSSignaturePackage;
import com.liferay.digital.signature.request.CreatePackageDSSignatureRequest;

/**
 * @author Michael C. Han
 */
public class CreatePackageDSSignatureRequestImpl
	implements CreatePackageDSSignatureRequest {

	public CreatePackageDSSignatureRequestImpl(
		DSSessionKey dsSessionKey, DSSignaturePackage dsSignaturePackage,
		DSSignaturePackageStatus dsSignaturePackageStatus) {

		_dsSessionKey = dsSessionKey;
		_dsSignaturePackage = dsSignaturePackage;
		_dsSignaturePackageStatus = dsSignaturePackageStatus;
	}

	@Override
	public DSSessionKey getDSSessionKey() {
		return _dsSessionKey;
	}

	@Override
	public DSSignaturePackage getDSSignaturePackage() {
		return _dsSignaturePackage;
	}

	@Override
	public DSSignaturePackageStatus getDSSignaturePackageStatus() {
		return _dsSignaturePackageStatus;
	}

	private final DSSessionKey _dsSessionKey;
	private final DSSignaturePackage _dsSignaturePackage;
	private final DSSignaturePackageStatus _dsSignaturePackageStatus;

}