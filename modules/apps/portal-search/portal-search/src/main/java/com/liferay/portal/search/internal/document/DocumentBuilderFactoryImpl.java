/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.document;

import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.document.DocumentBuilder;
import com.liferay.portal.search.document.DocumentBuilderFactory;
import com.liferay.portal.search.document.Field;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Wade Cao
 */
@Component(service = DocumentBuilderFactory.class)
public class DocumentBuilderFactoryImpl implements DocumentBuilderFactory {

	@Override
	public DocumentBuilder builder() {
		return new DocumentBuilderImpl();
	}

	@Override
	public DocumentBuilder builder(Document document) {
		DocumentBuilder documentBuilder = new DocumentBuilderImpl();

		Map<String, Field> map = document.getFields();

		map.forEach(
			(name, field) -> documentBuilder.setValues(
				name, field.getValues()));

		return documentBuilder;
	}

}