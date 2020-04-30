/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.util.DDMStructurePermissionSupport;
import com.liferay.portlet.documentlibrary.constants.DLConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcellus Tavares
 */
@Component(
	property = {
		"default.model.resource.name=true",
		"model.class.name=com.liferay.document.library.kernel.util.RawMetadataProcessor"
	},
	service = DDMStructurePermissionSupport.class
)
public class RawMetadataProcessorDDMStructurePermissionSupport
	implements DDMStructurePermissionSupport {

	@Override
	public String getResourceName() {
		return DLConstants.RESOURCE_NAME;
	}

}