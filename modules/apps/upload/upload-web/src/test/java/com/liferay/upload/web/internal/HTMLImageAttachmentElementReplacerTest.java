/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.upload.web.internal;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepository;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileEntryWrapper;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import org.powermock.api.mockito.PowerMockito;

/**
 * @author Alejandro Tardín
 */
public class HTMLImageAttachmentElementReplacerTest extends PowerMockito {

	@Before
	public void setUp() {
		_fileEntry = new FileEntryWrapper(null) {

			@Override
			public long getFileEntryId() {
				return _IMAGE_FILE_ENTRY_ID;
			}

		};

		_portletFileRepository = mock(PortletFileRepository.class);

		when(
			_portletFileRepository.getPortletFileEntryURL(
				Mockito.isNull(ThemeDisplay.class), Mockito.eq(_fileEntry),
				Mockito.eq(StringPool.BLANK))
		).thenReturn(
			_FILE_ENTRY_IMAGE_URL
		);

		_htmlImageAttachmentElementReplacer =
			new HTMLImageAttachmentElementReplacer();

		_htmlImageAttachmentElementReplacer.setPortletFileRepository(
			_portletFileRepository);
	}

	@Test
	public void testKeepsCustomAttributes() throws Exception {
		String originalImgTag = String.format(
			"<img class=\"custom\" data-image-id=\"%s\" src=\"%s\" />",
			_IMAGE_FILE_ENTRY_ID, StringUtil.randomString());
		String expectedImgTag = String.format(
			"<img class=\"custom\" src=\"%s\" />", _FILE_ENTRY_IMAGE_URL);

		String actualTag = _htmlImageAttachmentElementReplacer.replace(
			originalImgTag, _fileEntry);

		Assert.assertEquals(expectedImgTag, actualTag);
	}

	@Test
	public void testRemovesTemporalAttributeAndSetsFinalSrc() throws Exception {
		String originalImgTag = String.format(
			"<img data-image-id=\"%s\" src=\"%s\" />", _IMAGE_FILE_ENTRY_ID,
			StringUtil.randomString());
		String expectedImgTag = String.format(
			"<img src=\"%s\" />", _FILE_ENTRY_IMAGE_URL);

		String actualTag = _htmlImageAttachmentElementReplacer.replace(
			originalImgTag, _fileEntry);

		Assert.assertEquals(expectedImgTag, actualTag);
	}

	private static final String _FILE_ENTRY_IMAGE_URL =
		RandomTestUtil.randomString();

	private static final long _IMAGE_FILE_ENTRY_ID =
		RandomTestUtil.randomLong();

	private FileEntry _fileEntry;
	private HTMLImageAttachmentElementReplacer
		_htmlImageAttachmentElementReplacer;
	private PortletFileRepository _portletFileRepository;

}