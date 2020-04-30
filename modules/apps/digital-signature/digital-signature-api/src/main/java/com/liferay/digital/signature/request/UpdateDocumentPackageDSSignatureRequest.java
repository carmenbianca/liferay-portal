/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.request;

import com.liferay.digital.signature.model.DSDocument;
import com.liferay.digital.signature.response.DSSignatureResponse;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface UpdateDocumentPackageDSSignatureRequest
	extends PackageDSSignatureRequest {

	@Override
	public default DSSignatureResponse execute(
		PackageDSSignatureRequestExecutor packageDSSignatureRequestExecutor) {

		return packageDSSignatureRequestExecutor.execute(this);
	}

	public List<DSDocument> getDSDocuments();

	public String getDSSignaturePackageKey();

}