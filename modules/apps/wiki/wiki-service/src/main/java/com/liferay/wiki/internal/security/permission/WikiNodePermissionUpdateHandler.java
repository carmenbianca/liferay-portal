/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.security.permission;

import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.service.WikiNodeLocalService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gergely Mathe
 */
@Component(
	property = "model.class.name=com.liferay.wiki.model.WikiNode",
	service = PermissionUpdateHandler.class
)
public class WikiNodePermissionUpdateHandler
	implements PermissionUpdateHandler {

	@Override
	public void updatedPermission(String primKey) {
		WikiNode wikiNode = _wikiNodeLocalService.fetchWikiNode(
			GetterUtil.getLong(primKey));

		if (wikiNode == null) {
			return;
		}

		wikiNode.setModifiedDate(new Date());

		_wikiNodeLocalService.updateWikiNode(wikiNode);
	}

	@Reference(unbind = "-")
	protected void setWikiNodeLocalService(
		WikiNodeLocalService wikiNodeLocalService) {

		_wikiNodeLocalService = wikiNodeLocalService;
	}

	private WikiNodeLocalService _wikiNodeLocalService;

}