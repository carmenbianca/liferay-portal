/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.security.permission.support;

import com.liferay.dynamic.data.mapping.constants.DDMConstants;
import com.liferay.dynamic.data.mapping.util.DDMStructurePermissionSupport;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rafael Praxedes
 */
@Component(
	immediate = true,
	property = {
		"default.model.resource.name=true",
		"model.class.name=com.liferay.dynamic.data.mapping.model.DDMFormInstance"
	},
	service = DDMStructurePermissionSupport.class
)
public class DDMFormDDMPermissionSupport
	implements DDMStructurePermissionSupport {

	@Override
	public String getResourceName() {
		return DDMConstants.RESOURCE_NAME;
	}

}