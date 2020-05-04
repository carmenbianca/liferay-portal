/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.validator;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.FileImpl;

import java.io.InputStream;

import org.hamcrest.core.StringStartsWith;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Rubén Pulido
 */
public class JSONValidatorTest {

	@Before
	public void setUp() {
		new FileUtil().setFile(new FileImpl());
	}

	@Test
	public void testValidateExampleInvalidExtraProperties() throws Exception {
		expectedException.expect(JSONValidatorException.class);
		expectedException.expectMessage(
			new StringStartsWith("extraneous key [extra] is not permitted"));

		JSONValidator.validate(
			_read("example_invalid_extra_properties.json"),
			_readJSONSchemaAsStream());
	}

	@Test
	public void testValidateExampleInvalidRequiredPropertyMissing()
		throws Exception {

		expectedException.expect(JSONValidatorException.class);
		expectedException.expectMessage(
			new StringStartsWith("required key [example] not found"));

		JSONValidator.validate(
			_read("example_invalid_required_property_missing.json"),
			_readJSONSchemaAsStream());
	}

	@Test
	public void testValidateExampleValidRequired() throws Exception {
		JSONValidator.validate(
			_read("example_valid_required.json"), _readJSONSchemaAsStream());
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private static InputStream _readJSONSchemaAsStream() {
		return JSONValidatorTest.class.getResourceAsStream(
			"dependencies/example_json_schema.json");
	}

	private String _read(String fileName) throws Exception {
		return new String(
			FileUtil.getBytes(getClass(), "dependencies/" + fileName));
	}

}