/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.indexer;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface IndexerSummaryBuilder {

	public Summary getSummary(Document document, String snippet, Locale locale);

}