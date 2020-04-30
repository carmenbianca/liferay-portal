/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.resolver;

import com.liferay.change.tracking.resolver.helper.ConstraintResolverHelper;
import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.lang.SafeClosable;
import com.liferay.portal.kernel.change.tracking.CTCollectionThreadLocal;
import com.liferay.portal.kernel.model.change.tracking.CTModel;
import com.liferay.portal.kernel.service.change.tracking.CTService;

/**
 * @author Preston Crary
 */
public class ConstraintResolverHelperImpl<T extends CTModel<T>>
	implements ConstraintResolverHelper<T> {

	public ConstraintResolverHelperImpl(
		CTService<T> ctService, long targetCTCollectionId) {

		_ctService = ctService;
		_targetCTCollectionId = targetCTCollectionId;
	}

	@Override
	public <R, E extends Throwable> R getInTarget(
			UnsafeSupplier<R, E> unsafeSupplier)
		throws E {

		try (SafeClosable safeClosable =
				CTCollectionThreadLocal.setCTCollectionId(
					_targetCTCollectionId)) {

			return unsafeSupplier.get();
		}
	}

	@Override
	public T getSourceCTModel() {
		return _ctService.updateWithUnsafeFunction(
			ctPersistence -> ctPersistence.fetchByPrimaryKey(
				_sourcePrimaryKey));
	}

	@Override
	public T getTargetCTModel() {
		try (SafeClosable safeClosable =
				CTCollectionThreadLocal.setCTCollectionId(
					_targetCTCollectionId)) {

			return _ctService.updateWithUnsafeFunction(
				ctPersistence -> ctPersistence.fetchByPrimaryKey(
					_targetPrimaryKey));
		}
	}

	public void setPrimaryKeys(long sourcePrimaryKey, long targetPrimaryKey) {
		_sourcePrimaryKey = sourcePrimaryKey;
		_targetPrimaryKey = targetPrimaryKey;
	}

	private final CTService<T> _ctService;
	private long _sourcePrimaryKey;
	private final long _targetCTCollectionId;
	private long _targetPrimaryKey;

}