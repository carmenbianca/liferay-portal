/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.document;

import com.liferay.portal.search.document.DocumentBuilder;
import com.liferay.portal.search.document.DocumentBuilderFactory;
import com.liferay.portal.search.elasticsearch6.internal.document.DocumentFieldsTranslator;
import com.liferay.portal.search.engine.adapter.document.BulkableDocumentRequestTranslator;
import com.liferay.portal.search.engine.adapter.document.GetDocumentRequest;
import com.liferay.portal.search.engine.adapter.document.GetDocumentResponse;
import com.liferay.portal.search.geolocation.GeoBuilders;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = GetDocumentRequestExecutor.class)
public class GetDocumentRequestExecutorImpl
	implements GetDocumentRequestExecutor {

	@Override
	public GetDocumentResponse execute(GetDocumentRequest getDocumentRequest) {
		GetRequestBuilder getRequestBuilder =
			_bulkableDocumentRequestTranslator.translate(getDocumentRequest);

		GetResponse getResponse = getRequestBuilder.get();

		GetDocumentResponse getDocumentResponse = new GetDocumentResponse(
			getResponse.isExists());

		if (!getResponse.isExists()) {
			return getDocumentResponse;
		}

		getDocumentResponse.setSource(getResponse.getSourceAsString());
		getDocumentResponse.setVersion(getResponse.getVersion());

		DocumentFieldsTranslator documentFieldsTranslator =
			new DocumentFieldsTranslator(_geoBuilders);

		DocumentBuilder documentBuilder = _documentBuilderFactory.builder();

		documentFieldsTranslator.translate(
			documentBuilder, getResponse.getSourceAsMap());

		getDocumentResponse.setDocument(documentBuilder.build());

		return getDocumentResponse;
	}

	@Reference(target = "(search.engine.impl=Elasticsearch)", unbind = "-")
	protected void setBulkableDocumentRequestTranslator(
		BulkableDocumentRequestTranslator bulkableDocumentRequestTranslator) {

		_bulkableDocumentRequestTranslator = bulkableDocumentRequestTranslator;
	}

	@Reference(unbind = "-")
	protected void setDocumentBuilderFactory(
		DocumentBuilderFactory documentBuilderFactory) {

		_documentBuilderFactory = documentBuilderFactory;
	}

	@Reference(unbind = "-")
	protected void setGeoBuilders(GeoBuilders geoBuilders) {
		_geoBuilders = geoBuilders;
	}

	private BulkableDocumentRequestTranslator
		_bulkableDocumentRequestTranslator;
	private DocumentBuilderFactory _documentBuilderFactory;
	private GeoBuilders _geoBuilders;

}