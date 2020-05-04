/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.document;

import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.document.DocumentBuilder;
import com.liferay.portal.search.internal.document.DocumentBuilderImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author André de Oliveira
 */
public class DocumentFieldsTranslatorTest {

	@Test
	public void testDocumentSourceMapWithMultiValueField() {
		DocumentFieldsTranslator documentFieldsTranslator =
			new DocumentFieldsTranslator(null);

		DocumentBuilder documentBuilder = new DocumentBuilderImpl();

		String fieldName = RandomTestUtil.randomString();

		List<String> list1 = Arrays.asList(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		documentFieldsTranslator.translate(
			documentBuilder, Collections.singletonMap(fieldName, list1));

		Document document = documentBuilder.build();

		List<String> list2 = document.getStrings(fieldName);

		Assert.assertEquals(list1.toString(), list2.toString());
	}

}