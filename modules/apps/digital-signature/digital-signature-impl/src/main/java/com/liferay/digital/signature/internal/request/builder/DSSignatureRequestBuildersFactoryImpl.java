/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.request.builder;

import com.liferay.digital.signature.model.DSSessionKey;
import com.liferay.digital.signature.request.builder.CreatePackageDSSignatureRequestBuilder;
import com.liferay.digital.signature.request.builder.DSSignatureRequestBuildersFactory;
import com.liferay.digital.signature.request.builder.VoidPackageDSSignatureRequestBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = DSSignatureRequestBuildersFactory.class)
public class DSSignatureRequestBuildersFactoryImpl
	implements DSSignatureRequestBuildersFactory {

	@Override
	public CreatePackageDSSignatureRequestBuilder
		createCreatePackageDSSignatureRequestBuilder(
			DSSessionKey dsSessionKey) {

		return new CreatePackageDSSignatureRequestBuilderImpl(dsSessionKey);
	}

	@Override
	public VoidPackageDSSignatureRequestBuilder
		createVoidPackageDSSignatureRequestBuilder(DSSessionKey dsSessionKey) {

		return new VoidPackageDSSignatureRequestBuilderImpl(dsSessionKey);
	}

}