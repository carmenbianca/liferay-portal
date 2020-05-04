/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.model.impl;

import com.liferay.sharing.security.permission.SharingEntryAction;

/**
 * The extended model implementation for the {@code SharingEntry} service.
 * Represents a row in the {@code SharingEntry} database table, with each column
 * mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun Service Builder to copy their definitions
 * into the {@code com.liferay.sharing.model.SharingEntry} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class SharingEntryImpl extends SharingEntryBaseImpl {

	/**
	 * Returns {@code true} if the sharing entry has the sharing entry action.
	 *
	 * @param  sharingEntryAction the sharing entry action
	 * @return {@code true} if the sharing entry has the sharing entry action;
	 *         {@code false} otherwise
	 * @review
	 */
	@Override
	public boolean hasSharingPermission(SharingEntryAction sharingEntryAction) {
		if ((getActionIds() & sharingEntryAction.getBitwiseValue()) != 0) {
			return true;
		}

		return false;
	}

}