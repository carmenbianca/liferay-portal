/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Connor McKay
 */
public interface PersistedModelLocalServiceRegistry {

	public PersistedModelLocalService getPersistedModelLocalService(
		String className);

	public List<PersistedModelLocalService> getPersistedModelLocalServices();

	public void register(
		String className,
		PersistedModelLocalService persistedModelLocalService);

	public void unregister(String className);

}