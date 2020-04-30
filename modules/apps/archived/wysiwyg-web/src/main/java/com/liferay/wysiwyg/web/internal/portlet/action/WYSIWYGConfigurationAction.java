/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wysiwyg.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.wysiwyg.web.internal.constants.WYSIWYGPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Peter Fellwock
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + WYSIWYGPortletKeys.WYSIWYG,
	service = ConfigurationAction.class
)
public class WYSIWYGConfigurationAction extends DefaultConfigurationAction {
}