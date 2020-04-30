/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.document;

import com.liferay.portal.search.document.Document;

import org.apache.solr.common.SolrInputDocument;

/**
 * @author Michael C. Han
 */
public interface SolrDocumentFactory {

	/**
	 * @deprecated As of Mueller (7.2.x)
	 */
	@Deprecated
	public SolrInputDocument getSolrInputDocument(
		com.liferay.portal.kernel.search.Document document);

	public SolrInputDocument getSolrInputDocument(Document document);

}