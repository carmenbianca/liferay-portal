/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.uad.test;

import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.service.MBCategoryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * @author Brian Wing Shun Chan
 */
public class MBCategoryUADTestUtil {

	public static MBCategory addMBCategory(
			MBCategoryLocalService mbCategoryLocalService, long userId)
		throws Exception {

		return addMBCategory(mbCategoryLocalService, userId, 0L);
	}

	public static MBCategory addMBCategory(
			MBCategoryLocalService mbCategoryLocalService, long userId,
			long parentMBCategoryId)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getGroupId());

		return mbCategoryLocalService.addCategory(
			userId, parentMBCategoryId, RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), serviceContext);
	}

	public static MBCategory addMBCategoryWithStatusByUserId(
			MBCategoryLocalService mbCategoryLocalService, long userId,
			long statusByUserId)
		throws Exception {

		MBCategory mbCategory = addMBCategory(mbCategoryLocalService, userId);

		return mbCategoryLocalService.updateStatus(
			statusByUserId, mbCategory.getCategoryId(),
			WorkflowConstants.STATUS_APPROVED);
	}

}