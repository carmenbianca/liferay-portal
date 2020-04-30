/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.summary;

import com.liferay.portal.kernel.search.Document;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface SummaryHelper {

	public Locale getSnippetLocale(Document document, Locale locale);

}