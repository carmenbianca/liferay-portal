/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.request;

import com.liferay.digital.signature.model.DSSessionKey;
import com.liferay.digital.signature.request.VoidPackageDSSignatureRequest;

/**
 * @author Michael C. Han
 */
public class VoidPackageDSSignatureRequestImpl
	implements VoidPackageDSSignatureRequest {

	public VoidPackageDSSignatureRequestImpl(
		DSSessionKey dsSessionKey, String dsSignaturePackageKey,
		String voidReason) {

		_dsSessionKey = dsSessionKey;
		_dsSignaturePackageKey = dsSignaturePackageKey;
		_voidReason = voidReason;
	}

	@Override
	public DSSessionKey getDSSessionKey() {
		return _dsSessionKey;
	}

	@Override
	public String getDSSignaturePackageKey() {
		return _dsSignaturePackageKey;
	}

	@Override
	public String getExternalReferenceKey() {
		return _externalReferenceKey;
	}

	@Override
	public String getVoidReason() {
		return _voidReason;
	}

	public void setExternalReferenceKey(String externalReferenceKey) {
		_externalReferenceKey = externalReferenceKey;
	}

	private final DSSessionKey _dsSessionKey;
	private final String _dsSignaturePackageKey;
	private String _externalReferenceKey;
	private final String _voidReason;

}