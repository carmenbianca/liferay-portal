/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.model.impl;

import com.liferay.message.boards.constants.MBCategoryConstants;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.service.MBCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MBCategoryImpl extends MBCategoryBaseImpl {

	@Override
	public List<Long> getAncestorCategoryIds() throws PortalException {
		List<Long> ancestorCategoryIds = new ArrayList<>();

		MBCategory category = this;

		while (!category.isRoot()) {
			category = MBCategoryLocalServiceUtil.getCategory(
				category.getParentCategoryId());

			ancestorCategoryIds.add(category.getCategoryId());
		}

		return ancestorCategoryIds;
	}

	@Override
	public List<MBCategory> getAncestors() throws PortalException {
		List<MBCategory> ancestors = new ArrayList<>();

		MBCategory category = this;

		while (!category.isRoot()) {
			category = category.getParentCategory();

			ancestors.add(category);
		}

		return ancestors;
	}

	@Override
	public MBCategory getParentCategory() throws PortalException {
		long parentCategoryId = getParentCategoryId();

		if ((parentCategoryId ==
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) ||
			(parentCategoryId == MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			return null;
		}

		return MBCategoryLocalServiceUtil.getCategory(getParentCategoryId());
	}

	@Override
	public boolean isRoot() {
		if (getParentCategoryId() ==
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

			return true;
		}

		return false;
	}

}