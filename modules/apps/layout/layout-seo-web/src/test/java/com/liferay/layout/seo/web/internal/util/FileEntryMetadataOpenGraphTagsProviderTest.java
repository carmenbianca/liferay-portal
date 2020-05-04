/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.web.internal.util;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryMetadata;
import com.liferay.document.library.kernel.service.DLFileEntryMetadataLocalService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.StorageEngine;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Collections;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Adolfo Pérez
 */
public class FileEntryMetadataOpenGraphTagsProviderTest {

	@Before
	public void setUp() {
		_fileEntryMetadataOpenGraphTagsProvider =
			new FileEntryMetadataOpenGraphTagsProvider(
				_ddmStructureLocalService, _dlFileEntryMetadataLocalService,
				_portal, _storageEngine);
	}

	@Test
	public void testGetKeyValuePairsFileEntryWithEmptyTiffMetadata()
		throws Exception {

		Mockito.when(
			_fileEntry.getModel()
		).thenReturn(
			Mockito.mock(DLFileEntry.class)
		);

		Mockito.when(
			_fileEntry.getFileVersion()
		).thenReturn(
			Mockito.mock(FileVersion.class)
		);

		Mockito.when(
			_ddmStructureLocalService.getClassStructures(
				Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(OrderByComparator.class))
		).thenReturn(
			Collections.singletonList(Mockito.mock(DDMStructure.class))
		);

		Mockito.when(
			_dlFileEntryMetadataLocalService.fetchFileEntryMetadata(
				Mockito.anyLong(), Mockito.anyLong())
		).thenReturn(
			_dlFileEntryMetadata
		);

		Mockito.when(
			_storageEngine.getDDMFormValues(Mockito.anyLong())
		).thenReturn(
			_ddmFormValues
		);

		Mockito.when(
			_ddmFormValues.getDDMFormFieldValuesMap()
		).thenReturn(
			Collections.singletonMap(
				"TIFF_IMAGE_LENGTH", Collections.emptyList())
		);

		Assert.assertEquals(
			Collections.emptyList(),
			_fileEntryMetadataOpenGraphTagsProvider.
				getFileEntryMetadataOpenGraphTagKeyValuePairs(_fileEntry));
	}

	@Test
	public void testGetKeyValuePairsFileEntryWithNoDDMFormValues()
		throws Exception {

		Mockito.when(
			_fileEntry.getModel()
		).thenReturn(
			Mockito.mock(DLFileEntry.class)
		);

		Mockito.when(
			_fileEntry.getFileVersion()
		).thenReturn(
			Mockito.mock(FileVersion.class)
		);

		Mockito.when(
			_ddmStructureLocalService.getClassStructures(
				Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(OrderByComparator.class))
		).thenReturn(
			Collections.singletonList(Mockito.mock(DDMStructure.class))
		);

		Mockito.when(
			_dlFileEntryMetadataLocalService.fetchFileEntryMetadata(
				Mockito.anyLong(), Mockito.anyLong())
		).thenReturn(
			_dlFileEntryMetadata
		);

		Mockito.when(
			_storageEngine.getDDMFormValues(Mockito.anyLong())
		).thenReturn(
			null
		);

		Assert.assertEquals(
			Collections.emptyList(),
			_fileEntryMetadataOpenGraphTagsProvider.
				getFileEntryMetadataOpenGraphTagKeyValuePairs(_fileEntry));
	}

	@Test
	public void testGetKeyValuePairsFileEntryWithNoDLFileEntryMetadata()
		throws Exception {

		Mockito.when(
			_fileEntry.getModel()
		).thenReturn(
			Mockito.mock(DLFileEntry.class)
		);

		Mockito.when(
			_fileEntry.getFileVersion()
		).thenReturn(
			Mockito.mock(FileVersion.class)
		);

		Mockito.when(
			_ddmStructureLocalService.getClassStructures(
				Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(OrderByComparator.class))
		).thenReturn(
			Collections.singletonList(Mockito.mock(DDMStructure.class))
		);

		Mockito.when(
			_dlFileEntryMetadataLocalService.fetchFileEntryMetadata(
				Mockito.anyLong(), Mockito.anyLong())
		).thenReturn(
			null
		);

		Assert.assertEquals(
			Collections.emptyList(),
			_fileEntryMetadataOpenGraphTagsProvider.
				getFileEntryMetadataOpenGraphTagKeyValuePairs(_fileEntry));
	}

	@Test
	public void testGetKeyValuePairsFileEntryWithNoMetadata() throws Exception {
		Mockito.when(
			_fileEntry.getModel()
		).thenReturn(
			Mockito.mock(DLFileEntry.class)
		);

		Mockito.when(
			_fileEntry.getFileVersion()
		).thenReturn(
			Mockito.mock(FileVersion.class)
		);

		Mockito.when(
			_ddmStructureLocalService.getClassStructures(
				Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(OrderByComparator.class))
		).thenReturn(
			Collections.emptyList()
		);

		Assert.assertEquals(
			Collections.emptyList(),
			_fileEntryMetadataOpenGraphTagsProvider.
				getFileEntryMetadataOpenGraphTagKeyValuePairs(_fileEntry));
	}

	@Test
	public void testGetKeyValuePairsFileEntryWithNoTiffMetadata()
		throws Exception {

		Mockito.when(
			_fileEntry.getModel()
		).thenReturn(
			Mockito.mock(DLFileEntry.class)
		);

		Mockito.when(
			_fileEntry.getFileVersion()
		).thenReturn(
			Mockito.mock(FileVersion.class)
		);

		Mockito.when(
			_ddmStructureLocalService.getClassStructures(
				Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(OrderByComparator.class))
		).thenReturn(
			Collections.singletonList(Mockito.mock(DDMStructure.class))
		);

		Mockito.when(
			_dlFileEntryMetadataLocalService.fetchFileEntryMetadata(
				Mockito.anyLong(), Mockito.anyLong())
		).thenReturn(
			_dlFileEntryMetadata
		);

		Mockito.when(
			_storageEngine.getDDMFormValues(Mockito.anyLong())
		).thenReturn(
			_ddmFormValues
		);

		Mockito.when(
			_ddmFormValues.getDDMFormFieldValuesMap()
		).thenReturn(
			Collections.emptyMap()
		);

		Assert.assertEquals(
			Collections.emptyList(),
			_fileEntryMetadataOpenGraphTagsProvider.
				getFileEntryMetadataOpenGraphTagKeyValuePairs(_fileEntry));
	}

	@Test
	public void testGetKeyValuePairsFileEntryWithTiffMetadata()
		throws Exception {

		Mockito.when(
			_fileEntry.getModel()
		).thenReturn(
			Mockito.mock(DLFileEntry.class)
		);

		Mockito.when(
			_fileEntry.getFileVersion()
		).thenReturn(
			Mockito.mock(FileVersion.class)
		);

		Mockito.when(
			_ddmStructureLocalService.getClassStructures(
				Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(OrderByComparator.class))
		).thenReturn(
			Collections.singletonList(Mockito.mock(DDMStructure.class))
		);

		Mockito.when(
			_dlFileEntryMetadataLocalService.fetchFileEntryMetadata(
				Mockito.anyLong(), Mockito.anyLong())
		).thenReturn(
			_dlFileEntryMetadata
		);

		Mockito.when(
			_storageEngine.getDDMFormValues(Mockito.anyLong())
		).thenReturn(
			_ddmFormValues
		);

		Mockito.when(
			_ddmFormValues.getDDMFormFieldValuesMap()
		).thenReturn(
			Collections.singletonMap(
				"TIFF_IMAGE_LENGTH",
				Collections.singletonList(_ddmFormFieldValue))
		);

		Mockito.when(
			_ddmFormFieldValue.getValue()
		).thenReturn(
			_value
		);

		String expectedValue = StringUtil.randomString();

		Mockito.when(
			_value.getString(Mockito.any(Locale.class))
		).thenReturn(
			expectedValue
		);

		Assert.assertEquals(
			ListUtil.fromArray(
				new KeyValuePair("og:image:height", expectedValue)),
			_fileEntryMetadataOpenGraphTagsProvider.
				getFileEntryMetadataOpenGraphTagKeyValuePairs(_fileEntry));
	}

	@Test
	public void testGetKeyValuePairsNondlFileEntry() throws Exception {
		Assert.assertEquals(
			Collections.emptyList(),
			_fileEntryMetadataOpenGraphTagsProvider.
				getFileEntryMetadataOpenGraphTagKeyValuePairs(_fileEntry));
	}

	private final DDMFormFieldValue _ddmFormFieldValue = Mockito.mock(
		DDMFormFieldValue.class);
	private final DDMFormValues _ddmFormValues = Mockito.mock(
		DDMFormValues.class);
	private final DDMStructureLocalService _ddmStructureLocalService =
		Mockito.mock(DDMStructureLocalService.class);
	private final DLFileEntryMetadata _dlFileEntryMetadata = Mockito.mock(
		DLFileEntryMetadata.class);
	private final DLFileEntryMetadataLocalService
		_dlFileEntryMetadataLocalService = Mockito.mock(
			DLFileEntryMetadataLocalService.class);
	private final FileEntry _fileEntry = Mockito.mock(FileEntry.class);
	private FileEntryMetadataOpenGraphTagsProvider
		_fileEntryMetadataOpenGraphTagsProvider;
	private final Portal _portal = Mockito.mock(Portal.class);
	private final StorageEngine _storageEngine = Mockito.mock(
		StorageEngine.class);
	private final Value _value = Mockito.mock(Value.class);

}