/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.request;

import com.liferay.digital.signature.response.DSSignatureResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface PackageDSSignatureRequest extends DSSignatureRequest {

	public DSSignatureResponse execute(
		PackageDSSignatureRequestExecutor packageDSSignatureRequestExecutor);

}