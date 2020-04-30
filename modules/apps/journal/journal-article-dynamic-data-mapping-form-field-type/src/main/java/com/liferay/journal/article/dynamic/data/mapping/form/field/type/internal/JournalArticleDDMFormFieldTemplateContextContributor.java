/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.article.dynamic.data.mapping.form.field.type.internal;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.criteria.JournalArticleItemSelectorReturnType;
import com.liferay.item.selector.criteria.info.item.criterion.InfoItemItemSelectorCriterion;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.Map;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=journal_article",
	service = {
		DDMFormFieldTemplateContextContributor.class,
		JournalArticleDDMFormFieldTemplateContextContributor.class
	}
)
public class JournalArticleDDMFormFieldTemplateContextContributor
	implements DDMFormFieldTemplateContextContributor {

	@Override
	public Map<String, Object> getParameters(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		LocalizedValue localizedValue =
			(LocalizedValue)ddmFormField.getProperty("predefinedValue");

		String predefinedValue = StringPool.BLANK;

		if (localizedValue != null) {
			predefinedValue = GetterUtil.getString(
				localizedValue.getString(
					ddmFormFieldRenderingContext.getLocale()));
		}

		return HashMapBuilder.<String, Object>put(
			"itemSelectorURL",
			getItemSelectorURL(
				ddmFormFieldRenderingContext,
				ddmFormFieldRenderingContext.getHttpServletRequest())
		).put(
			"portletNamespace",
			ddmFormFieldRenderingContext.getPortletNamespace()
		).put(
			"predefinedValue", predefinedValue
		).put(
			"value",
			GetterUtil.getString(
				ddmFormFieldRenderingContext.getProperty("value"))
		).build();
	}

	protected String getItemSelectorURL(
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext,
		HttpServletRequest httpServletRequest) {

		if (_itemSelector == null) {
			return null;
		}

		InfoItemItemSelectorCriterion infoItemItemSelectorCriterion =
			new InfoItemItemSelectorCriterion();

		infoItemItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
			new JournalArticleItemSelectorReturnType());

		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
			RequestBackedPortletURLFactoryUtil.create(httpServletRequest),
			ddmFormFieldRenderingContext.getPortletNamespace() +
				"selectJournalArticle",
			infoItemItemSelectorCriterion);

		return itemSelectorURL.toString();
	}

	@Reference
	private ItemSelector _itemSelector;

}