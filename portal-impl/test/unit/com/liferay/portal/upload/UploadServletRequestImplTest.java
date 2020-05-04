/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upload;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.tools.ToolDependencies;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Roberto Díaz
 */
public class UploadServletRequestImplTest {

	@Before
	public void setUp() {
		ToolDependencies.wireCaches();

		_fileItems.add(_getFileItem("A", 12));
		_fileItems.add(_getFileItem("B", 92));
		_fileItems.add(_getFileItem("F", 80));
		_fileItems.add(_getFileItem("FIRST_ELEMENT_FIELD_NAME", 1));
		_fileItems.add(_getFileItem("G", 80));
		_fileItems.add(_getFileItem("LAST_ELEMENT_FIELD_NAME", 999));
		_fileItems.add(_getFileItem("REPEATED_ELEMENT_FIELD_NAME", 2));
		_fileItems.add(_getFileItem("REPEATED_ELEMENT_FIELD_NAME", 1));
		_fileItems.add(_getFileItem("S", 65));
		_fileItems.add(_getFileItem("T", 34));
	}

	@Test
	public void testSort() {
		UploadServletRequestImpl uploadServletRequestImpl =
			new UploadServletRequestImpl(new MockHttpServletRequest());

		List<FileItem> sortedFileItems = uploadServletRequestImpl.sort(
			_fileItems);

		Assert.assertEquals(
			sortedFileItems.toString(), 10, sortedFileItems.size());

		String previousFieldName = StringPool.BLANK;
		long previousSize = 0;

		for (FileItem sortedFileItem : sortedFileItems) {
			String fieldName = sortedFileItem.getFieldName();
			long size = sortedFileItem.getSize();

			if (!previousFieldName.equals(fieldName)) {
				Assert.assertTrue(previousSize <= size);
			}

			previousFieldName = fieldName;
			previousSize = size;
		}
	}

	@Test
	public void testSortKeepsOriginalOrderWithSameParameterName() {
		UploadServletRequestImpl uploadServletRequestImpl =
			new UploadServletRequestImpl(new MockHttpServletRequest());

		List<FileItem> sortedFileItems = uploadServletRequestImpl.sort(
			_fileItems);

		FileItem fileItem1 = sortedFileItems.get(1);

		Assert.assertEquals(
			"REPEATED_ELEMENT_FIELD_NAME", fileItem1.getFieldName());
		Assert.assertEquals(2, fileItem1.getSize());

		FileItem fileItem2 = sortedFileItems.get(2);

		Assert.assertEquals(
			"REPEATED_ELEMENT_FIELD_NAME", fileItem2.getFieldName());
		Assert.assertEquals(1, fileItem2.getSize());
	}

	private FileItem _getFileItem(String fieldName, long size) {
		FileItem fileItem = new DiskFileItem(
			fieldName, null, false, null, 0, null);

		ReflectionTestUtil.setFieldValue(fileItem, "size", size);

		return fileItem;
	}

	private final List<FileItem> _fileItems = new ArrayList<>();

}