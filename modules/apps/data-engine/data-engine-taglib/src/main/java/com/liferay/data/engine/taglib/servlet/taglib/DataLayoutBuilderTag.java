/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.data.engine.taglib.servlet.taglib;

import com.liferay.data.engine.taglib.servlet.taglib.base.BaseDataLayoutBuilderTag;
import com.liferay.data.engine.taglib.servlet.taglib.util.DataLayoutTaglibUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LinkedHashMapBuilder;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

/**
 * @author Jeyvison Nascimento
 * @author Leonardo Barros
 */
public class DataLayoutBuilderTag extends BaseDataLayoutBuilderTag {

	@Override
	public int doStartTag() throws JspException {
		int result = super.doStartTag();

		try {
			HttpServletRequest httpServletRequest = getRequest();

			setNamespacedAttribute(
				httpServletRequest, "dataLayoutBuilderModule",
				DataLayoutTaglibUtil.resolveModule(
					"data-engine-taglib/data_layout_builder/js" +
						"/DataLayoutBuilder.es"));
			setNamespacedAttribute(
				httpServletRequest, "fieldTypes",
				DataLayoutTaglibUtil.getFieldTypesJSONArray(
					httpServletRequest, getScopes()));
			setNamespacedAttribute(
				httpServletRequest, "fieldTypesModules",
				DataLayoutTaglibUtil.resolveFieldTypesModules());
			setNamespacedAttribute(
				httpServletRequest, "sidebarPanels", _getSidebarPanels());
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		return result;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		super.setAttributes(httpServletRequest);

		Set<Locale> availableLocales = DataLayoutTaglibUtil.getAvailableLocales(
			getDataDefinitionId(), getDataLayoutId(), httpServletRequest);

		setNamespacedAttribute(
			httpServletRequest, "availableLanguageIds",
			_getLanguageIds(availableLocales));
		setNamespacedAttribute(
			httpServletRequest, "availableLocales",
			availableLocales.toArray(new Locale[0]));

		HttpServletRequest tagHttpServletRequest = getRequest();

		setNamespacedAttribute(
			httpServletRequest, "config",
			DataLayoutTaglibUtil.getDataLayoutConfigJSONObject(
				getContentType(), tagHttpServletRequest.getLocale()));

		setNamespacedAttribute(
			httpServletRequest, "dataLayout",
			DataLayoutTaglibUtil.getDataLayoutJSONObject(
				availableLocales, getDataDefinitionId(), getDataLayoutId(),
				httpServletRequest,
				(HttpServletResponse)pageContext.getResponse()));
	}

	private String[] _getLanguageIds(Set<Locale> locales) {
		Stream<Locale> stream = locales.stream();

		return stream.map(
			LanguageUtil::getLanguageId
		).toArray(
			String[]::new
		);
	}

	private Map<String, Object> _getSidebarPanels() {
		HttpServletRequest httpServletRequest = getRequest();

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", httpServletRequest.getLocale(), getClass());

		Map<String, Object> sidebarPanels =
			LinkedHashMapBuilder.<String, Object>put(
				"fields",
				HashMapBuilder.<String, Object>put(
					"icon", "forms"
				).put(
					"isLink", false
				).put(
					"label", LanguageUtil.get(resourceBundle, "builder")
				).put(
					"pluginEntryPoint",
					DataLayoutTaglibUtil.resolveModule(
						"data-engine-taglib/data_layout_builder/js/plugins" +
							"/fields-sidebar/index.es")
				).put(
					"sidebarPanelId", "fields"
				).build()
			).put(
				"rules",
				HashMapBuilder.<String, Object>put(
					"icon", "rules"
				).put(
					"isLink", false
				).put(
					"label", LanguageUtil.get(resourceBundle, "rules")
				).put(
					"pluginEntryPoint",
					DataLayoutTaglibUtil.resolveModule(
						"data-engine-taglib/data_layout_builder/js/plugins" +
							"/rules-sidebar/index.es")
				).put(
					"sidebarPanelId", "rules"
				).build()
			).build();

		List<Map> additionalPanels = getAdditionalPanels();

		if (ListUtil.isEmpty(additionalPanels)) {
			return sidebarPanels;
		}

		for (Map<String, Object> additionalPanel : additionalPanels) {
			sidebarPanels.put(
				(String)additionalPanel.get("sidebarPanelId"), additionalPanel);
		}

		return sidebarPanels;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DataLayoutBuilderTag.class);

}