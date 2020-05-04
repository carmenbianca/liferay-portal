/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.internal.dto.v2_0.util;

import com.liferay.data.engine.rest.dto.v2_0.DataRecordCollection;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import org.powermock.api.mockito.PowerMockito;

/**
 * @author Mateus Santana
 */
@RunWith(MockitoJUnitRunner.class)
public class DataRecordCollectionUtilTest extends PowerMockito {

	@Before
	public void setUp() {
		_setUpLanguageUtil();
	}

	@Test
	public void testToDataRecordCollectionEquals() throws Exception {
		when(
			_ddlRecordSet.getDDMStructureId()
		).thenReturn(
			123L
		);

		when(
			_ddlRecordSet.getDescriptionMap()
		).thenReturn(
			HashMapBuilder.put(
				LocaleUtil.BRAZIL, "Descrição"
			).put(
				LocaleUtil.US, "Description"
			).build()
		);

		when(
			_ddlRecordSet.getGroupId()
		).thenReturn(
			789L
		);

		when(
			_ddlRecordSet.getNameMap()
		).thenReturn(
			HashMapBuilder.put(
				LocaleUtil.BRAZIL, "Nome"
			).put(
				LocaleUtil.US, "Name"
			).build()
		);

		when(
			_ddlRecordSet.getRecordSetId()
		).thenReturn(
			456L
		);

		when(
			_ddlRecordSet.getRecordSetKey()
		).thenReturn(
			"RecordSetId"
		);

		Assert.assertEquals(
			new DataRecordCollection() {
				{
					setDataDefinitionId(123L);
					setDataRecordCollectionKey("RecordSetId");
					setDescription(
						HashMapBuilder.<String, Object>put(
							"en_US", "Description"
						).put(
							"pt_BR", "Descrição"
						).build());
					setId(456L);
					setName(
						HashMapBuilder.<String, Object>put(
							"en_US", "Name"
						).put(
							"pt_BR", "Nome"
						).build());
					setSiteId(789L);
				}
			},
			DataRecordCollectionUtil.toDataRecordCollection(_ddlRecordSet));
	}

	@Test
	public void testToDataRecordCollectionNotEquals() throws Exception {
		when(
			_ddlRecordSet.getDDMStructureId()
		).thenReturn(
			124L
		);

		when(
			_ddlRecordSet.getDescriptionMap()
		).thenReturn(
			HashMapBuilder.put(
				LocaleUtil.BRAZIL, "Descrição1"
			).put(
				LocaleUtil.US, "Description1"
			).build()
		);

		when(
			_ddlRecordSet.getGroupId()
		).thenReturn(
			788L
		);

		when(
			_ddlRecordSet.getNameMap()
		).thenReturn(
			HashMapBuilder.put(
				LocaleUtil.BRAZIL, "Nome1"
			).put(
				LocaleUtil.US, "Name1"
			).build()
		);

		when(
			_ddlRecordSet.getRecordSetId()
		).thenReturn(
			457L
		);

		when(
			_ddlRecordSet.getRecordSetKey()
		).thenReturn(
			"RecordSetId1"
		);

		Assert.assertNotEquals(
			new DataRecordCollection() {
				{
					setDataDefinitionId(123L);
					setDataRecordCollectionKey("RecordSetId");
					setDescription(
						HashMapBuilder.<String, Object>put(
							"en_US", "Description"
						).put(
							"pt_BR", "Descrição"
						).build());
					setId(456L);
					setName(
						HashMapBuilder.<String, Object>put(
							"en_US", "Name"
						).put(
							"pt_BR", "Nome"
						).build());
					setSiteId(789L);
				}
			},
			DataRecordCollectionUtil.toDataRecordCollection(_ddlRecordSet));
	}

	@Test
	public void testToDataRecordCollectionNullDDLRecordSet() {
		Assert.assertEquals(
			new DataRecordCollection(),
			DataRecordCollectionUtil.toDataRecordCollection(null));
	}

	private void _setUpLanguageUtil() {
		LanguageUtil languageUtil = new LanguageUtil();

		Language language = mock(Language.class);

		when(
			language.isAvailableLocale(LocaleUtil.BRAZIL)
		).thenReturn(
			true
		);

		when(
			language.isAvailableLocale(LocaleUtil.US)
		).thenReturn(
			true
		);

		when(
			language.getLanguageId(LocaleUtil.BRAZIL)
		).thenReturn(
			"pt_BR"
		);

		when(
			language.getLanguageId(LocaleUtil.US)
		).thenReturn(
			"en_US"
		);

		languageUtil.setLanguage(language);
	}

	@Mock
	private DDLRecordSet _ddlRecordSet;

}