/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.service.impl;

import com.liferay.petra.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity;
import com.liferay.portal.tools.service.builder.test.service.base.LazyBlobEntityLocalServiceBaseImpl;

/**
 * @author Kyle Miho
 */
public class LazyBlobEntityLocalServiceImpl
	extends LazyBlobEntityLocalServiceBaseImpl {

	@Override
	public LazyBlobEntity addLazyBlobEntity(
		long groupId, byte[] bytes, ServiceContext serviceContext) {

		long lazyBlobEntityId = counterLocalService.increment();

		LazyBlobEntity lazyBlobEntity = lazyBlobEntityPersistence.create(
			lazyBlobEntityId);

		lazyBlobEntity.setUuid(serviceContext.getUuid());
		lazyBlobEntity.setGroupId(groupId);

		UnsyncByteArrayInputStream unsyncByteArrayInputStream =
			new UnsyncByteArrayInputStream(bytes);

		OutputBlob outputBlob = new OutputBlob(
			unsyncByteArrayInputStream, bytes.length);

		lazyBlobEntity.setBlob1(outputBlob);
		lazyBlobEntity.setBlob2(outputBlob);

		return lazyBlobEntityPersistence.update(lazyBlobEntity);
	}

}