/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.paragraph;

import com.google.template.soy.data.SanitizedContent;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldTypeSettingsTestCase;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.template.soy.internal.data.SoyDataFactoryImpl;
import com.liferay.portal.util.HtmlImpl;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Pedro Queiroz
 */
public class ParagraphDDMFormFieldTemplateContextContributorTest
	extends BaseDDMFormFieldTypeSettingsTestCase {

	@Before
	@Override
	public void setUp() {
		HtmlUtil htmlUtil = new HtmlUtil();

		htmlUtil.setHtml(new HtmlImpl());

		ReflectionTestUtil.setFieldValue(
			_paragraphDDMFormFieldTemplateContextContributor, "_soyDataFactory",
			new SoyDataFactoryImpl());
	}

	@Test
	public void testGetParameters() {
		DDMFormField ddmFormField = new DDMFormField("field", "paragraph");

		LocalizedValue text = new LocalizedValue();

		text.addString(text.getDefaultLocale(), "<b>This is a header</b>\n");

		ddmFormField.setProperty("text", text);

		Map<String, Object> parameters =
			_paragraphDDMFormFieldTemplateContextContributor.getParameters(
				ddmFormField, new DDMFormFieldRenderingContext());

		SanitizedContent sanitizedContent = (SanitizedContent)parameters.get(
			"text");

		Assert.assertEquals(
			text.getString(text.getDefaultLocale()),
			sanitizedContent.getContent());
	}

	@Test
	public void testGetParametersWhenInViewMode() {
		DDMFormField ddmFormField = new DDMFormField("field", "paragraph");

		LocalizedValue text = new LocalizedValue();

		text.addString(text.getDefaultLocale(), "<p>This is a paragraph</p>\n");

		ddmFormField.setProperty("text", text);

		DDMFormFieldRenderingContext ddmFormFieldRenderingContext =
			new DDMFormFieldRenderingContext();

		ddmFormFieldRenderingContext.setViewMode(true);

		Map<String, Object> parameters =
			_paragraphDDMFormFieldTemplateContextContributor.getParameters(
				ddmFormField, ddmFormFieldRenderingContext);

		SanitizedContent sanitizedContent = (SanitizedContent)parameters.get(
			"text");

		Assert.assertEquals(
			text.getString(text.getDefaultLocale()),
			sanitizedContent.getContent());
	}

	private final ParagraphDDMFormFieldTemplateContextContributor
		_paragraphDDMFormFieldTemplateContextContributor =
			new ParagraphDDMFormFieldTemplateContextContributor();

}