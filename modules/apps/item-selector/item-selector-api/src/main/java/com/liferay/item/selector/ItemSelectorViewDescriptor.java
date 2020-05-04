/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Date;
import java.util.Locale;

/**
 * @author Alejandro Tardín
 */
public interface ItemSelectorViewDescriptor<T> {

	public ItemDescriptor getItemDescriptor(T t);

	public ItemSelectorReturnType getItemSelectorReturnType();

	public default String[] getOrderByKeys() {
		return null;
	}

	public SearchContainer getSearchContainer() throws PortalException;

	public default boolean isShowBreadcrumb() {
		return true;
	}

	public default boolean isShowManagementToolbar() {
		return true;
	}

	public default boolean isShowSearch() {
		return false;
	}

	public interface ItemDescriptor {

		public String getIcon();

		public String getImageURL();

		public default Date getModifiedDate() {
			return null;
		}

		public String getPayload();

		/**
		 * @deprecated As of Athanasius (7.3.x), replaced by {@link
		 *             #getSubtitle(Locale)}
		 */
		@Deprecated
		public default String getSubtitle() {
			return getSubtitle(LocaleUtil.getDefault());
		}

		public String getSubtitle(Locale locale);

		/**
		 * @deprecated As of Athanasius (7.3.x), replaced by {@link
		 *             #getTitle(Locale)}
		 */
		@Deprecated
		public default String getTitle() {
			return getTitle(LocaleUtil.getDefault());
		}

		public String getTitle(Locale locale);

		public default long getUserId() {
			return UserConstants.USER_ID_DEFAULT;
		}

		public default String getUserName() {
			return StringPool.BLANK;
		}

		public default boolean isCompact() {
			return false;
		}

	}

}