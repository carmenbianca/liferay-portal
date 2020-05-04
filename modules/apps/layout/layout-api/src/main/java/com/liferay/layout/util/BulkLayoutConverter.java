/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util;

import com.liferay.layout.util.template.LayoutConversionResult;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;

import java.util.Locale;

/**
 * @author Rubén Pulido
 * @review
 */
public interface BulkLayoutConverter {

	/**
	 * Converts a layout of type {@link LayoutConstants#TYPE_PORTLET} into a
	 * layout of type {@link LayoutConstants#TYPE_CONTENT}
	 *
	 * @param  plid the primary key of the layout
	 * @throws PortalException if a portal exception occurred
	 */
	public void convertLayout(long plid) throws PortalException;

	/**
	 * Converts all convertible layouts in the group of type {@link
	 * LayoutConstants#TYPE_PORTLET} into layouts of type {@link
	 * LayoutConstants#TYPE_CONTENT}
	 *
	 * <p>
	 * This method handles the conversion of each layout within a transaction.
	 * </p>
	 *
	 * @param  groupId the primary key of the group
	 * @return an array with the plids of the layouts that have been
	 *         successfully converted
	 */
	public long[] convertLayouts(long groupId) throws PortalException;

	/**
	 * Converts multiple layouts of type {@link LayoutConstants#TYPE_PORTLET}
	 * into layouts of type {@link LayoutConstants#TYPE_CONTENT}
	 *
	 * <p>
	 * This method handles the conversion of each layout within a transaction.
	 * </p>
	 *
	 * @param  plids an array with the primary keys of the layouts to be
	 *         converted
	 * @return an array with the plids of the layouts that have been
	 *         successfully converted
	 */
	public long[] convertLayouts(long[] plids);

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #generatePreviewLayout(long, Locale)}
	 */
	@Deprecated
	public Layout generatePreviewLayout(long plid) throws Exception;

	public default LayoutConversionResult generatePreviewLayout(
			long plid, Locale locale)
		throws Exception {

		return LayoutConversionResult.of(
			null, new String[0], generatePreviewLayout(plid));
	}

	/**
	 * Returns the plids of the convertible layouts in the group
	 *
	 * @param  groupId the primary key of the group
	 * @return an array with the plids of the convertible layouts in the group
	 */
	public long[] getConvertibleLayoutPlids(long groupId)
		throws PortalException;

}