/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.change.tracking.store;

import com.liferay.document.library.kernel.store.Store;

/**
 * @author Shuyang Zhou
 */
public interface CTStoreFactory {

	public Store createCTStore(Store store, String storeType);

}