/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.validator.test;

import com.liferay.layout.page.template.exception.PageTemplateCollectionValidatorException;
import com.liferay.layout.page.template.validator.PageTemplateCollectionValidator;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.FileImpl;

import org.hamcrest.core.StringStartsWith;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Rubén Pulido
 */
public class PageTemplateCollectionValidatorTest {

	@Before
	public void setUp() {
		new FileUtil().setFile(new FileImpl());
	}

	@Test
	public void testValidatePageDefinitionInvalidExtraProperties()
		throws Exception {

		expectedException.expect(
			PageTemplateCollectionValidatorException.class);
		expectedException.expectMessage(
			new StringStartsWith("extraneous key [extra] is not permitted"));

		PageTemplateCollectionValidator.validatePageTemplateCollection(
			_read("page_template_collection_invalid_extra_properties.json"));
	}

	@Test
	public void testValidatePageDefinitionInvalidMissingName()
		throws Exception {

		expectedException.expect(
			PageTemplateCollectionValidatorException.class);
		expectedException.expectMessage(
			new StringStartsWith("required key [name] not found"));

		PageTemplateCollectionValidator.validatePageTemplateCollection(
			_read("page_template_collection_invalid_missing_name.json"));
	}

	@Test
	public void testValidatePageDefinitionValidComplete() throws Exception {
		PageTemplateCollectionValidator.validatePageTemplateCollection(
			_read("page_template_collection_valid_complete.json"));
	}

	@Test
	public void testValidatePageDefinitionValidRequired() throws Exception {
		PageTemplateCollectionValidator.validatePageTemplateCollection(
			_read("page_template_collection_valid_required.json"));
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private String _read(String fileName) throws Exception {
		return new String(
			FileUtil.getBytes(getClass(), "dependencies/" + fileName));
	}

}