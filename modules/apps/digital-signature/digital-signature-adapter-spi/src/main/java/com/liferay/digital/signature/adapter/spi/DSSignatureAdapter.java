/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.adapter.spi;

import com.liferay.digital.signature.request.PackageDSSignatureRequest;
import com.liferay.digital.signature.response.DSSignatureResponse;

/**
 * @author Michael C. Han
 */
public interface DSSignatureAdapter {

	public DSSignatureResponse execute(
		PackageDSSignatureRequest packageDSSignatureRequest);

	public String getAdapterProviderName();

}