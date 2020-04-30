/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.servlet.taglib.definition;

import com.liferay.data.engine.taglib.servlet.taglib.definition.DataLayoutBuilderDefinition;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true, property = "content.type=journal",
	service = DataLayoutBuilderDefinition.class
)
public class JournalDataLayoutBuilderDefinition
	implements DataLayoutBuilderDefinition {

	@Override
	public boolean allowFieldSets() {
		return true;
	}

	@Override
	public boolean allowMultiplePages() {
		return false;
	}

	@Override
	public String[] getDisabledProperties() {
		return new String[] {"predefinedValue"};
	}

	@Override
	public String[] getDisabledTabs() {
		return new String[] {"Autocomplete"};
	}

}