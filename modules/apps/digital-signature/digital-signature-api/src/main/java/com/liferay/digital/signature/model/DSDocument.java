/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSDocument {

	public static final String PDF_EXTENSION = "pdf";

	public Boolean getAuthoritative();

	public String getBase64String();

	public String getDescription();

	public String getDocumentKey();

	public String getDocumentURL();

	public DSSupplementalDocumentInfo getDSSupplementalDocumentInfo();

	public String getExtension();

	public String getName();

}