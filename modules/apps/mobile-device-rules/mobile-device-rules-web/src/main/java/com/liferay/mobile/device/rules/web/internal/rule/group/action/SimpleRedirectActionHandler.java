/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.web.internal.rule.group.action;

import com.liferay.mobile.device.rules.action.ActionHandler;
import com.liferay.mobile.device.rules.model.MDRAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Edward Han
 */
@Component(immediate = true, service = ActionHandler.class)
public class SimpleRedirectActionHandler extends BaseRedirectActionHandler {

	public static String getHandlerType() {
		return SimpleRedirectActionHandler.class.getName();
	}

	@Override
	public String getEditorJSP() {
		return "/action/simple_url.jsp";
	}

	@Override
	public Collection<String> getPropertyNames() {
		return _propertyNames;
	}

	@Override
	public String getType() {
		return getHandlerType();
	}

	@Override
	protected String getURL(
		MDRAction mdrAction, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		UnicodeProperties typeSettingsUnicodeProperties =
			mdrAction.getTypeSettingsProperties();

		return GetterUtil.getString(
			typeSettingsUnicodeProperties.getProperty("url"));
	}

	private static final Collection<String> _propertyNames =
		Collections.unmodifiableCollection(Arrays.asList("url"));

}