/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.content.page.editor.web.internal.segments;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author David Arques
 */
public class SegmentsExperienceUtilTest {

	@Before
	public void setUp() {
		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(new JSONFactoryImpl());
	}

	@Test
	public void testCopyEditableValuesConfigurationWithExistingSourceSegmentsExperienceId()
		throws Exception {

		long existingSourceSegmentsExperienceId = 0L;
		long targetSegmentsExperienceId = 2L;

		JSONObject editableValuesJSONObject =
			SegmentsExperienceUtil.copyEditableValues(
				JSONFactoryUtil.createJSONObject(
					_getJsonFileAsString(
						"editable_values_configuration_matching_segments_" +
							"experience.json")),
				existingSourceSegmentsExperienceId, targetSegmentsExperienceId);

		JSONObject expectedEditableValuesJSONObject =
			JSONFactoryUtil.createJSONObject(
				_getJsonFileAsString(
					"editable_values_configuration_matching_segments_" +
						"experience_expected.json"));

		Assert.assertEquals(
			expectedEditableValuesJSONObject.toJSONString(),
			editableValuesJSONObject.toJSONString());
	}

	@Test
	public void testCopyEditableValuesWithExistingSourceSegmentsExperienceId()
		throws Exception {

		long existingSourceSegmentsExperienceId = 0L;
		long targetSegmentsExperienceId = 2L;

		JSONObject editableValuesJSONObject =
			SegmentsExperienceUtil.copyEditableValues(
				JSONFactoryUtil.createJSONObject(
					_getJsonFileAsString(
						"editable_values_matching_segments_experience.json")),
				existingSourceSegmentsExperienceId, targetSegmentsExperienceId);

		JSONObject expectedEditableValuesJSONObject =
			JSONFactoryUtil.createJSONObject(
				_getJsonFileAsString(
					"editable_values_matching_segments_experience_" +
						"expected.json"));

		Assert.assertEquals(
			expectedEditableValuesJSONObject.toJSONString(),
			editableValuesJSONObject.toJSONString());
	}

	@Test
	public void testCopyEditableValuesWithNonexistingSourceSegmentsExperienceId()
		throws Exception {

		long nonexistingSourceSegmentsExperienceId = 2L;
		long targetSegmentsExperienceId = 3L;

		JSONObject editableValuesJSONObject =
			SegmentsExperienceUtil.copyEditableValues(
				JSONFactoryUtil.createJSONObject(
					_getJsonFileAsString(
						"editable_values_unmatching_segments_experience.json")),
				nonexistingSourceSegmentsExperienceId,
				targetSegmentsExperienceId);

		JSONObject expectedEditableValuesJSONObject =
			JSONFactoryUtil.createJSONObject(
				_getJsonFileAsString(
					"editable_values_unmatching_segments_experience_" +
						"expected.json"));

		Assert.assertEquals(
			expectedEditableValuesJSONObject.toJSONString(),
			editableValuesJSONObject.toJSONString());
	}

	private String _getFileAsString(String fileName) throws IOException {
		Class<?> clazz = getClass();

		return StringUtil.read(
			clazz.getClassLoader(),
			"com/liferay/layout/content/page/editor/web/internal/segments" +
				"/dependencies/" + fileName);
	}

	private String _getJsonFileAsString(String jsonFileName)
		throws IOException, JSONException {

		String json = _getFileAsString(jsonFileName);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(json);

		return jsonObject.toString();
	}

}