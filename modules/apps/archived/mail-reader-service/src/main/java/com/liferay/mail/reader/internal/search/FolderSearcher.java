/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.internal.search;

import com.liferay.mail.reader.model.Folder;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

/**
 * @author Scott Lee
 * @author Peter Fellwock
 * @author Luan Maoski
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.mail.reader.model.Folder",
	service = BaseSearcher.class
)
public class FolderSearcher extends BaseSearcher {

	public static final String CLASS_NAME = Folder.class.getName();

	public FolderSearcher() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}