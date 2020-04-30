/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.resolver;

import com.liferay.change.tracking.resolver.helper.ConstraintResolverHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.change.tracking.CTModel;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Preston Crary
 */
public interface ConstraintResolver<T extends CTModel<T>> {

	public String getConflictDescriptionKey();

	public Class<T> getModelClass();

	public String getResolutionDescriptionKey();

	public ResourceBundle getResourceBundle(Locale locale);

	public String[] getUniqueIndexColumnNames();

	public void resolveConflict(
			ConstraintResolverHelper<T> constraintResolverHelper)
		throws PortalException;

}