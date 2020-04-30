/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.builder;

import com.liferay.digital.signature.model.DSDocument;
import com.liferay.digital.signature.model.DSDocumentDisplay;
import com.liferay.digital.signature.model.DSSignerAcknowledgement;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSDocumentBuilder {

	public DSDocument getDSDocument();

	public DSDocumentBuilder setAuthoritative(Boolean authoritative);

	public DSDocumentBuilder setBase64String(String base64String);

	public DSDocumentBuilder setDescription(String description);

	public DSDocumentBuilder setDocumentURL(String documentURL);

	public DSDocumentBuilder setExtension(String extension);

	public DSDocumentBuilder setSupplementalDocumentInfo(
		DSDocumentDisplay dsDocumentDisplay,
		DSSignerAcknowledgement dsSignerAcknowledgement,
		Boolean includeInDownload);

}