/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.liferayrepository.social;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.social.BaseSocialActivityManager;
import com.liferay.portal.kernel.social.SocialActivityManager;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.social.kernel.service.SocialActivityLocalService;

/**
 * @author Adolfo Pérez
 */
@OSGiBeanProperties(
	property = "model.class.name=com.liferay.portal.repository.liferayrepository.model.LiferayFolder",
	service = SocialActivityManager.class
)
public class LiferayFolderSocialActivityManager
	extends BaseSocialActivityManager<Folder> {

	@Override
	protected String getClassName(Folder folder) {
		return DLFolderConstants.getClassName();
	}

	@Override
	protected SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	@BeanReference(type = SocialActivityLocalService.class)
	protected SocialActivityLocalService socialActivityLocalService;

}