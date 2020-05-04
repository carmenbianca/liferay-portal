/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ratings.kernel.transformer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.ratings.kernel.RatingsType;
import com.liferay.ratings.kernel.model.RatingsEntry;

/**
 * Provides an interface defining the transformations to be applied to the
 * ratings data when the ratings type used by an entity is changed to use a
 * different ratings type.
 *
 * <p>
 * Implementations must be registered in the OSGI Registry. The portal invokes
 * the highest ranking OSGI component implementing this interface when the
 * ratings type of an entity is changed.
 * </p>
 *
 * @author Roberto Díaz
 * @author Sergio González
 */
public interface RatingsDataTransformer {

	/**
	 * Defines the transformations to be applied on a ratings entry when the
	 * ratings type is changed from the previous ratings type to the new ratings
	 * type.
	 *
	 * <p>
	 * This method returns an {@link ActionableDynamicQuery.PerformActionMethod}
	 * for operating on a {@link RatingsEntry} entity to transform its values
	 * based on when the ratings type is changed.
	 * </p>
	 *
	 * @param  fromRatingsType the previous ratings type
	 * @param  toRatingsType the final ratings type
	 * @return an {@link ActionableDynamicQuery.PerformActionMethod} with the
	 *         actions to be applied to the ratings entry when the ratings type
	 *         changes.
	 */
	public ActionableDynamicQuery.PerformActionMethod<RatingsEntry>
			transformRatingsData(
				final RatingsType fromRatingsType,
				final RatingsType toRatingsType)
		throws PortalException;

}