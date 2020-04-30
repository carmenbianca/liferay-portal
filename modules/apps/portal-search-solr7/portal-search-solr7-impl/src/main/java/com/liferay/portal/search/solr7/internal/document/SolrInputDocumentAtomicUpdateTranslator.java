/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.document;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.Collection;
import java.util.Map;

import org.apache.solr.common.SolrInputDocument;

/**
 * @author Bryan Engler
 */
public class SolrInputDocumentAtomicUpdateTranslator {

	public static SolrInputDocument translate(
		SolrInputDocument solrInputDocument) {

		return _addAtomicUpdateModifiers(solrInputDocument);
	}

	private static SolrInputDocument _addAtomicUpdateModifiers(
		SolrInputDocument solrInputDocument) {

		SolrInputDocument modifiedSolrInputDocument = new SolrInputDocument();

		for (String fieldName : solrInputDocument.getFieldNames()) {
			Collection<Object> values = solrInputDocument.getFieldValues(
				fieldName);

			if (fieldName.equals(Field.UID)) {
				modifiedSolrInputDocument.setField(fieldName, values);

				continue;
			}

			Map<String, Object> modifiedValue =
				HashMapBuilder.<String, Object>put(
					"set", values
				).build();

			modifiedSolrInputDocument.setField(fieldName, modifiedValue);
		}

		return modifiedSolrInputDocument;
	}

}