/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.web.internal.portlet.action;

import com.liferay.contacts.web.internal.constants.ContactsPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ContactsPortletKeys.CONTACTS_CENTER,
		"javax.portlet.name=" + ContactsPortletKeys.MEMBERS,
		"javax.portlet.name=" + ContactsPortletKeys.PROFILE
	},
	service = ConfigurationAction.class
)
public class ContactsConfigurationAction extends DefaultConfigurationAction {
}