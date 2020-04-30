/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.sharepoint;

import com.liferay.petra.string.StringPool;

/**
 * @author Bruno Farache
 */
public class GroupSharepointStorageImpl extends BaseSharepointStorageImpl {

	@Override
	public Tree getFoldersTree(SharepointRequest sharepointRequest)
		throws Exception {

		Tree foldersTree = new Tree();

		String rootPath = sharepointRequest.getRootPath();

		for (String token : SharepointUtil.getStorageTokens()) {
			String path = rootPath.concat(
				StringPool.SLASH
			).concat(
				token
			);

			foldersTree.addChild(getFolderTree(path));
		}

		foldersTree.addChild(getFolderTree(rootPath));

		return foldersTree;
	}

}