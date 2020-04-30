/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.social;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.social.BaseSocialActivityManager;
import com.liferay.portal.kernel.social.SocialActivityManager;
import com.liferay.social.kernel.service.SocialActivityLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	property = "model.class.name=com.liferay.journal.model.JournalArticle",
	service = SocialActivityManager.class
)
public class JournalArticleSocialActivityManager
	extends BaseSocialActivityManager<JournalArticle> {

	@Override
	protected long getPrimaryKey(JournalArticle journalArticle) {
		return journalArticle.getResourcePrimKey();
	}

	@Override
	protected SocialActivityLocalService getSocialActivityLocalService() {
		return _socialActivityLocalService;
	}

	@Reference(unbind = "-")
	protected void setSocialActivityLocalService(
		SocialActivityLocalService socialActivityLocalService) {

		_socialActivityLocalService = socialActivityLocalService;
	}

	private SocialActivityLocalService _socialActivityLocalService;

}