/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.change.tracking.store;

import com.liferay.document.library.kernel.store.Store;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Shuyang Zhou
 */
public class CTStoreFactoryUtil {

	public static Store createCTStore(Store store, String storeType) {
		return _ctStoreFactory.createCTStore(store, storeType);
	}

	private static volatile CTStoreFactory _ctStoreFactory =
		ServiceProxyFactory.newServiceTrackedInstance(
			CTStoreFactory.class, CTStoreFactoryUtil.class, "_ctStoreFactory",
			true);

}