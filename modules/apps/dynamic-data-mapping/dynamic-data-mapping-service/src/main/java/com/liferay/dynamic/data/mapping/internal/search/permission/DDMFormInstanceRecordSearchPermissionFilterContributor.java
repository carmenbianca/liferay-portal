/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.search.permission;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.portal.search.permission.SearchPermissionFilterContributor;

import java.util.Optional;

import org.osgi.service.component.annotations.Component;

/**
 * @author Lino Alves
 */
@Component(immediate = true, service = SearchPermissionFilterContributor.class)
public class DDMFormInstanceRecordSearchPermissionFilterContributor
	implements SearchPermissionFilterContributor {

	@Override
	public Optional<String> getParentEntryClassNameOptional(
		String entryClassName) {

		if (entryClassName.equals(DDMFormInstanceRecord.class.getName())) {
			return Optional.of(DDMFormInstance.class.getName());
		}

		return Optional.empty();
	}

}