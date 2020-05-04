/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.search;

import com.liferay.message.boards.model.MBCategory;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

/**
 * @author Javier Gamarra
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.message.boards.model.MBCategory",
	service = BaseSearcher.class
)
public class MBCategorySearcher extends BaseSearcher {

	public static final String CLASS_NAME = MBCategory.class.getName();

	public MBCategorySearcher() {
		setDefaultSelectedFieldNames(
			Field.CLASS_NAME_ID, Field.CLASS_PK, Field.COMPANY_ID,
			Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
			Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}