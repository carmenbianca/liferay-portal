/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.social;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.social.BaseSocialActivityManager;
import com.liferay.social.kernel.service.SocialActivityLocalService;

/**
 * @author Adolfo Pérez
 */
public class DefaultSocialActivityManager<T extends ClassedModel & GroupedModel>
	extends BaseSocialActivityManager<T> {

	@Override
	protected SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	@BeanReference(type = SocialActivityLocalService.class)
	protected SocialActivityLocalService socialActivityLocalService;

}