/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.request.builder;

import com.liferay.digital.signature.internal.request.VoidPackageDSSignatureRequestImpl;
import com.liferay.digital.signature.model.DSSessionKey;
import com.liferay.digital.signature.request.VoidPackageDSSignatureRequest;
import com.liferay.digital.signature.request.builder.VoidPackageDSSignatureRequestBuilder;

/**
 * @author Michael C. Han
 */
public class VoidPackageDSSignatureRequestBuilderImpl
	implements VoidPackageDSSignatureRequestBuilder {

	public VoidPackageDSSignatureRequestBuilderImpl(DSSessionKey dsSessionKey) {
		_dsSessionKey = dsSessionKey;
	}

	@Override
	public VoidPackageDSSignatureRequest getVoidPackageDSSignatureRequest() {
		VoidPackageDSSignatureRequestImpl voidPackageDSSignatureRequestImpl =
			new VoidPackageDSSignatureRequestImpl(
				_dsSessionKey, _dsSignaturePackageKey, _voidReason);

		voidPackageDSSignatureRequestImpl.setExternalReferenceKey(
			_externalReferenceKey);

		return voidPackageDSSignatureRequestImpl;
	}

	@Override
	public VoidPackageDSSignatureRequestBuilder setDSSignaturePackageKey(
		String dsSignaturePackageKey) {

		_dsSignaturePackageKey = dsSignaturePackageKey;

		return this;
	}

	@Override
	public VoidPackageDSSignatureRequestBuilder setExternalReferenceKey(
		String externalReferenceKey) {

		_externalReferenceKey = externalReferenceKey;

		return this;
	}

	@Override
	public VoidPackageDSSignatureRequestBuilder setVoidReason(
		String voidReason) {

		_voidReason = voidReason;

		return this;
	}

	private final DSSessionKey _dsSessionKey;
	private String _dsSignaturePackageKey;
	private String _externalReferenceKey;
	private String _voidReason;

}