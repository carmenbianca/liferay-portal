/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.legacy.document;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.document.DocumentBuilder;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface DocumentBuilderFactory {

	public DocumentBuilder builder(Document document);

}