/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.servlet.taglib.definition;

import com.liferay.data.engine.taglib.servlet.taglib.definition.DataLayoutBuilderDefinition;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true, property = "content.type=document-library",
	service = DataLayoutBuilderDefinition.class
)
public class DocumentLibraryDataLayoutBuilderDefinition
	implements DataLayoutBuilderDefinition {

	@Override
	public boolean allowMultiplePages() {
		return false;
	}

	@Override
	public String[] getDisabledTabs() {
		return new String[] {"Autocomplete"};
	}

}