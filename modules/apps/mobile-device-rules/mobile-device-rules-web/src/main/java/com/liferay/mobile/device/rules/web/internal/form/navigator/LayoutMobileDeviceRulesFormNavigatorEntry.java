/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.web.internal.form.navigator;

import com.liferay.layout.page.template.constants.LayoutPageTemplateEntryTypeConstants;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryLocalService;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.servlet.taglib.ui.BaseJSPFormNavigatorEntry;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorConstants;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorEntry;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(
	property = "form.navigator.entry.order:Integer=80",
	service = FormNavigatorEntry.class
)
public class LayoutMobileDeviceRulesFormNavigatorEntry
	extends BaseJSPFormNavigatorEntry<Layout> {

	@Override
	public String getCategoryKey() {
		return FormNavigatorConstants.CATEGORY_KEY_LAYOUT_ADVANCED;
	}

	@Override
	public String getFormNavigatorId() {
		return FormNavigatorConstants.FORM_NAVIGATOR_ID_LAYOUT;
	}

	@Override
	public String getKey() {
		return "mobile-device-rules";
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, getKey());
	}

	@Override
	public boolean isVisible(User user, Layout layout) {
		Layout draftLayout = _layoutLocalService.fetchLayout(
			_portal.getClassNameId(Layout.class), layout.getPlid());

		if (draftLayout != null) {
			return false;
		}

		LayoutPageTemplateEntry layoutPageTemplateEntry =
			_layoutPageTemplateEntryLocalService.
				fetchLayoutPageTemplateEntryByPlid(layout.getPlid());

		if (layoutPageTemplateEntry == null) {
			layoutPageTemplateEntry =
				_layoutPageTemplateEntryLocalService.
					fetchLayoutPageTemplateEntryByPlid(layout.getClassPK());
		}

		if ((layoutPageTemplateEntry != null) &&
			Objects.equals(
				layoutPageTemplateEntry.getType(),
				LayoutPageTemplateEntryTypeConstants.TYPE_MASTER_LAYOUT)) {

			return false;
		}

		return super.isVisible(user, layout);
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.mobile.device.rules.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	@Override
	protected String getJspPath() {
		return "/layout/mobile_device_rules.jsp";
	}

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private LayoutPageTemplateEntryLocalService
		_layoutPageTemplateEntryLocalService;

	@Reference
	private Portal _portal;

}