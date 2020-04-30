/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.asset.auto.tagger.google.cloud.vision.internal.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.FileImpl;

import java.io.ByteArrayInputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author Alejandro Tardín
 */
public class GCloudVisionUtilTest {

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		FileUtil fileUtil = new FileUtil();

		fileUtil.setFile(new FileImpl());

		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(new JSONFactoryImpl());
	}

	@Test
	public void testGetAnnotateImagePayload() throws Exception {
		Mockito.when(
			_fileEntry.getFileVersion()
		).thenReturn(
			_fileVersion
		);

		String randomString = RandomTestUtil.randomString();

		Mockito.when(
			_fileVersion.getContentStream(false)
		).thenReturn(
			new ByteArrayInputStream(randomString.getBytes())
		);

		Assert.assertEquals(
			StringBundler.concat(
				"{\"requests\":[{\"features\":",
				"[{\"type\":\"LABEL_DETECTION\"}],\"image\":{\"content\":\"",
				Base64.encode(randomString.getBytes()), "\"}}]}"),
			GCloudVisionUtil.getAnnotateImagePayload(_fileEntry));
	}

	@Mock
	private FileEntry _fileEntry;

	@Mock
	private FileVersion _fileVersion;

}