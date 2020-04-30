/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.response.builder;

import com.liferay.digital.signature.response.builder.DSSignatureResponseBuilder;
import com.liferay.digital.signature.response.builder.DSSignatureResponseBuildersFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = DSSignatureResponseBuildersFactory.class)
public class DSSignatureResponseBuildersFactoryImpl
	implements DSSignatureResponseBuildersFactory {

	@Override
	public DSSignatureResponseBuilder createDSSignatureResponseBuilder(
		String dsSignatureRequestKey) {

		return new DSSignatureResponseBuilderImpl(dsSignatureRequestKey);
	}

}