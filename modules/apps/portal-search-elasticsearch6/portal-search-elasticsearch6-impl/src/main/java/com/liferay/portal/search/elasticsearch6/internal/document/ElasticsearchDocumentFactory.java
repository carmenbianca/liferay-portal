/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.document;

import com.liferay.portal.search.document.Document;

import org.elasticsearch.common.xcontent.XContentBuilder;

/**
 * @author Michael C. Han
 */
public interface ElasticsearchDocumentFactory {

	/**
	 * @deprecated As of Mueller (7.2.x)
	 */
	@Deprecated
	public String getElasticsearchDocument(
		com.liferay.portal.kernel.search.Document document);

	public XContentBuilder getElasticsearchDocument(Document document);

}