/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.web.internal.portlet.action;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.segments.constants.SegmentsPortletKeys;
import com.liferay.segments.field.customizer.SegmentsFieldCustomizer;
import com.liferay.segments.field.customizer.SegmentsFieldCustomizerRegistry;

import java.util.Locale;
import java.util.Optional;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author David Arques
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SegmentsPortletKeys.SEGMENTS,
		"mvc.command.name=getSegmentsFieldValueName"
	},
	service = MVCResourceCommand.class
)
public class GetSegmentsFieldValueNameMVCResourceCommand
	extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		JSONPortletResponseUtil.writeJSON(
			resourceRequest, resourceResponse,
			getFieldValueNameJSONObject(
				ParamUtil.getString(resourceRequest, "entityName"),
				ParamUtil.getString(resourceRequest, "fieldName"),
				ParamUtil.getString(resourceRequest, "fieldValue"),
				_portal.getLocale(resourceRequest)));
	}

	protected JSONObject getFieldValueNameJSONObject(
		String entityName, String fieldName, String fieldValue, Locale locale) {

		Optional<String> fieldValueNameOptional = _getFieldValueName(
			entityName, fieldName, fieldValue, locale);

		return JSONUtil.put(
			"fieldValueName", fieldValueNameOptional.orElse(null));
	}

	private Optional<String> _getFieldValueName(
		String entityName, String fieldName, String fieldValue, Locale locale) {

		Optional<SegmentsFieldCustomizer> segmentsFieldCustomizerOptional =
			_segmentsFieldCustomizerRegistry.getSegmentsFieldCustomizerOptional(
				entityName, fieldName);

		if (!segmentsFieldCustomizerOptional.isPresent()) {
			return Optional.empty();
		}

		SegmentsFieldCustomizer segmentsFieldCustomizer =
			segmentsFieldCustomizerOptional.get();

		return Optional.ofNullable(
			segmentsFieldCustomizer.getFieldValueName(fieldValue, locale));
	}

	@Reference
	private Portal _portal;

	@Reference
	private SegmentsFieldCustomizerRegistry _segmentsFieldCustomizerRegistry;

}