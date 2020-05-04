/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.uad.test;

import com.liferay.layout.test.util.LayoutFriendlyURLRandomizerBumper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutFriendlyURL;
import com.liferay.portal.kernel.service.LayoutFriendlyURLLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.test.randomizerbumpers.NumericStringRandomizerBumper;
import com.liferay.portal.kernel.test.randomizerbumpers.UniqueStringRandomizerBumper;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutFriendlyURLUADTestUtil {

	public static LayoutFriendlyURL addLayoutFriendlyURL(
			LayoutFriendlyURLLocalService layoutFriendlyURLLocalService,
			LayoutLocalService layoutLocalService, long userId)
		throws Exception {

		String name = RandomTestUtil.randomString(
			LayoutFriendlyURLRandomizerBumper.INSTANCE,
			NumericStringRandomizerBumper.INSTANCE,
			UniqueStringRandomizerBumper.INSTANCE);

		String friendlyURL =
			StringPool.SLASH + FriendlyURLNormalizerUtil.normalize(name);

		Layout layout = layoutLocalService.addLayout(
			userId, TestPropsValues.getGroupId(), false,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, name,
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			LayoutConstants.TYPE_PORTLET, false, friendlyURL,
			ServiceContextTestUtil.getServiceContext());

		return layoutFriendlyURLLocalService.getLayoutFriendlyURL(
			layout.getPlid(), layout.getDefaultLanguageId());
	}

	public static void cleanUpDependencies(
			LayoutLocalService layoutLocalService,
			List<LayoutFriendlyURL> layoutFriendlyURLs)
		throws Exception {

		for (LayoutFriendlyURL layoutFriendlyURL : layoutFriendlyURLs) {
			layoutLocalService.deleteLayout(layoutFriendlyURL.getPlid());
		}
	}

}