/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.flash.web.internal.portlet.action;

import com.liferay.flash.web.internal.constants.FlashPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Peter Fellwock
 */
@Component(
	immediate = true, property = "javax.portlet.name=" + FlashPortletKeys.FLASH,
	service = ConfigurationAction.class
)
public class FlashConfigurationAction extends DefaultConfigurationAction {
}