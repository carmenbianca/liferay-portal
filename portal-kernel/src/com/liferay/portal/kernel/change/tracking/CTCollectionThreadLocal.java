/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.change.tracking;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.petra.lang.SafeClosable;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Preston Crary
 */
public class CTCollectionThreadLocal {

	public static long getCTCollectionId() {
		return _ctCollectionId.get();
	}

	public static boolean isProductionMode() {
		if (_ctCollectionId.get() == 0) {
			return true;
		}

		return false;
	}

	public static void removeCTCollectionId() {
		_ctCollectionId.remove();
	}

	public static SafeClosable setCTCollectionId(long ctCollectionId) {
		return _ctCollectionId.setWithSafeClosable(ctCollectionId);
	}

	private static long _getCTCollectionId() {
		CTCollectionIdSupplier ctCollectionIdSupplier = _ctCollectionIdSupplier;

		if (ctCollectionIdSupplier == null) {
			return 0;
		}

		return ctCollectionIdSupplier.getCTCollectionId();
	}

	private CTCollectionThreadLocal() {
	}

	private static final CentralizedThreadLocal<Long> _ctCollectionId =
		new CentralizedThreadLocal<>(
			CTCollectionThreadLocal.class + "._ctCollectionId",
			CTCollectionThreadLocal::_getCTCollectionId);
	private static volatile CTCollectionIdSupplier _ctCollectionIdSupplier =
		ServiceProxyFactory.newServiceTrackedInstance(
			CTCollectionIdSupplier.class, CTCollectionThreadLocal.class,
			"_ctCollectionIdSupplier", false, true);

}