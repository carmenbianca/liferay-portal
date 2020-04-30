/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.request.builder;

import com.liferay.digital.signature.model.DSSessionKey;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSSignatureRequestBuildersFactory {

	public CreatePackageDSSignatureRequestBuilder
		createCreatePackageDSSignatureRequestBuilder(DSSessionKey dsSessionKey);

	public VoidPackageDSSignatureRequestBuilder
		createVoidPackageDSSignatureRequestBuilder(DSSessionKey dsSessionKey);

}