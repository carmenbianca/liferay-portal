/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.resolver.helper;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.portal.kernel.model.change.tracking.CTModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Preston Crary
 */
@ProviderType
public interface ConstraintResolverHelper<T extends CTModel<T>> {

	public <R, E extends Throwable> R getInTarget(
			UnsafeSupplier<R, E> unsafeSupplier)
		throws E;

	public T getSourceCTModel();

	public T getTargetCTModel();

}