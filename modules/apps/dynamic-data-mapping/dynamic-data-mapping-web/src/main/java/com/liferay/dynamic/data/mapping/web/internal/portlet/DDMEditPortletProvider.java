/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.web.internal.portlet;

import com.liferay.dynamic.data.mapping.constants.DDMPortletKeys;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.EditPortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rafael Praxedes
 */
@Component(
	immediate = true,
	property = {
		"model.class.name=com.liferay.dynamic.data.mapping.model.DDMStructure",
		"model.class.name=com.liferay.dynamic.data.mapping.model.DDMTemplate"
	},
	service = {EditPortletProvider.class, ViewPortletProvider.class}
)
public class DDMEditPortletProvider
	extends BasePortletProvider
	implements EditPortletProvider, ViewPortletProvider {

	@Override
	public String getPortletName() {
		return DDMPortletKeys.DYNAMIC_DATA_MAPPING;
	}

}