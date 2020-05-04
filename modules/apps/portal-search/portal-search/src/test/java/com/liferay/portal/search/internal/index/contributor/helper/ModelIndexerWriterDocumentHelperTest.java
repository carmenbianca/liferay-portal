/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.index.contributor.helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author Adam Brandizzi
 */
public class ModelIndexerWriterDocumentHelperTest {

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testException() throws PortalException {
		throwIndexNameBuilderException(new SystemException());

		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper =
			new ModelIndexerWriterDocumentHelperImpl(
				RandomTestUtil.randomString(), indexDocumentBuilder);

		modelIndexerWriterDocumentHelper.getDocument(baseModel);
	}

	protected void throwIndexNameBuilderException(Exception exception) {
		Mockito.when(
			indexDocumentBuilder.getDocument(Matchers.any())
		).thenThrow(
			exception
		);
	}

	@Mock
	protected BaseModel<?> baseModel;

	@Mock
	protected IndexerDocumentBuilder indexDocumentBuilder;

}