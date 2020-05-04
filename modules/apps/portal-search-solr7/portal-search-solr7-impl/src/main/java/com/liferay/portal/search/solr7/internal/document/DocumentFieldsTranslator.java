/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.document;

import com.liferay.portal.search.document.DocumentBuilder;

import java.util.Collection;

import org.apache.solr.common.SolrDocument;

/**
 * @author Bryan Engler
 */
public class DocumentFieldsTranslator {

	public static void translate(
		DocumentBuilder documentBuilder, SolrDocument solrDocument) {

		Collection<String> fieldNames = solrDocument.getFieldNames();

		for (String fieldName : fieldNames) {
			if (fieldName.equals(_VERSION_FIELD)) {
				continue;
			}

			documentBuilder.setValues(
				fieldName, solrDocument.getFieldValues(fieldName));
		}
	}

	private static final String _VERSION_FIELD = "_version_";

}