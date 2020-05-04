/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.webdav;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.webdav.BaseResourceImpl;
import com.liferay.portal.kernel.webdav.BaseWebDAVStorageImpl;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.webdav.WebDAVUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Chow
 */
public class GroupWebDAVStorageImpl extends BaseWebDAVStorageImpl {

	@Override
	public Resource getResource(WebDAVRequest webDAVRequest)
		throws WebDAVException {

		verifyGroup(webDAVRequest);

		String path = getRootPath() + webDAVRequest.getPath();

		return new BaseResourceImpl(path, StringPool.BLANK, StringPool.BLANK);
	}

	@Override
	public List<Resource> getResources(WebDAVRequest webDAVRequest)
		throws WebDAVException {

		verifyGroup(webDAVRequest);

		List<Resource> resources = new ArrayList<>();

		String path = getRootPath() + webDAVRequest.getPath();

		for (String token : WebDAVUtil.getStorageTokens()) {
			resources.add(new BaseResourceImpl(path, token, token));
		}

		return resources;
	}

	protected void verifyGroup(WebDAVRequest webDAVRequest)
		throws WebDAVException {

		String path = webDAVRequest.getPath();

		try {
			List<Group> groups = WebDAVUtil.getGroups(
				webDAVRequest.getUserId());

			for (Group group : groups) {
				if (path.equals(group.getFriendlyURL())) {
					return;
				}
			}
		}
		catch (Exception exception) {
		}

		throw new WebDAVException(
			"Invalid group for given credentials " +
				webDAVRequest.getRootPath() + path);
	}

}