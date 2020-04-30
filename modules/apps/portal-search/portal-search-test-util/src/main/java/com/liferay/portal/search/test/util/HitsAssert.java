/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;

import java.util.List;

import org.junit.Assert;

/**
 * @author André de Oliveira
 */
public class HitsAssert {

	public static void assertNoHits(Hits hits) {
		List<Document> documents = hits.toList();

		Assert.assertEquals(String.valueOf(documents), 0, hits.getLength());
	}

	public static Document assertOnlyOne(Hits hits) {
		List<Document> documents = hits.toList();

		Assert.assertEquals(String.valueOf(documents), 1, documents.size());

		return documents.get(0);
	}

	public static Document assertOnlyOne(String message, Hits hits) {
		List<Document> documents = hits.toList();

		Assert.assertEquals(
			_getMessage(message, documents), 1, documents.size());

		return documents.get(0);
	}

	private static String _getMessage(String message, Object actual) {
		return message + "->" + actual;
	}

}