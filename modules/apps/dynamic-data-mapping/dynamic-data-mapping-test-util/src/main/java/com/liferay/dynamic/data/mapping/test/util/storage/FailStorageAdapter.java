/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.test.util.storage;

import com.liferay.dynamic.data.mapping.exception.StorageException;
import com.liferay.dynamic.data.mapping.storage.BaseStorageAdapter;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Rafael Praxedes
 */
public class FailStorageAdapter extends BaseStorageAdapter {

	public static final String STORAGE_TYPE = "Fail";

	@Override
	public String getStorageType() {
		return STORAGE_TYPE;
	}

	@Override
	protected long doCreate(
			long companyId, long ddmStructureId, DDMFormValues ddmFormValues,
			ServiceContext serviceContext)
		throws Exception {

		throw new StorageException();
	}

	@Override
	protected void doDeleteByClass(long classPK) throws Exception {
		throw new StorageException();
	}

	@Override
	protected void doDeleteByDDMStructure(long ddmStructureId)
		throws Exception {

		throw new StorageException();
	}

	@Override
	protected DDMFormValues doGetDDMFormValues(long classPK) throws Exception {
		throw new StorageException();
	}

	@Override
	protected void doUpdate(
			long classPK, DDMFormValues ddmFormValues,
			ServiceContext serviceContext)
		throws Exception {

		throw new StorageException();
	}

}