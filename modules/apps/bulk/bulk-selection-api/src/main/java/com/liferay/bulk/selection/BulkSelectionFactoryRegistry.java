/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.selection;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public interface BulkSelectionFactoryRegistry {

	public <T> BulkSelectionFactory<T> getBulkSelectionFactory(long classNameId)
		throws PortalException;

	public <T> BulkSelectionFactory<T> getBulkSelectionFactory(
		String className);

}