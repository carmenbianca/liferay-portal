/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.admin.web.internal.servlet.taglib.ui;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorConstants;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorEntry;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	property = "form.navigator.entry.order:Integer=40",
	service = FormNavigatorEntry.class
)
public class SiteAnalyticsFormNavigatorEntry
	extends BaseSiteFormNavigatorEntry {

	@Override
	public String getCategoryKey() {
		return FormNavigatorConstants.CATEGORY_KEY_SITES_ADVANCED;
	}

	@Override
	public String getKey() {
		return "analytics";
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "analytics");
	}

	@Override
	public boolean isVisible(User user, Group group) {
		if ((group == null) || group.isCompany()) {
			return false;
		}

		String[] analyticsTypes = PrefsPropsUtil.getStringArray(
			group.getCompanyId(), PropsKeys.ADMIN_ANALYTICS_TYPES,
			StringPool.NEW_LINE);

		if (analyticsTypes.length == 0) {
			return false;
		}

		return true;
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.site.admin.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	@Override
	protected String getJspPath() {
		return "/site/analytics.jsp";
	}

}