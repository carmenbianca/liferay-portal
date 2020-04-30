/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.internal.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.util.DDMStructurePermissionSupport;
import com.liferay.layout.seo.model.LayoutSEOEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alicia Garcia
 */
@Component(
	property = "model.class.name=com.liferay.layout.seo.model.LayoutSEOEntry",
	service = DDMStructurePermissionSupport.class
)
public class LayoutSEOEntryDDMStructurePermissionSupport
	implements DDMStructurePermissionSupport {

	@Override
	public String getResourceName() {
		return LayoutSEOEntry.class.getName();
	}

}