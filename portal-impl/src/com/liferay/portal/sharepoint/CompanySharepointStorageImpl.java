/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.sharepoint;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.webdav.WebDAVUtil;

import java.util.List;

/**
 * @author Bruno Farache
 */
public class CompanySharepointStorageImpl extends BaseSharepointStorageImpl {

	@Override
	public Tree getFoldersTree(SharepointRequest sharepointRequest)
		throws Exception {

		Tree foldersTree = new Tree();

		List<Group> groups = WebDAVUtil.getGroups(sharepointRequest.getUser());

		for (Group group : groups) {
			String name = group.getFriendlyURL();

			name = name.substring(1);

			foldersTree.addChild(getFolderTree(name));
		}

		foldersTree.addChild(getFolderTree(StringPool.BLANK));

		return foldersTree;
	}

}