/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.display.context;

import com.liferay.document.library.kernel.versioning.VersioningStrategy;
import com.liferay.document.library.web.internal.display.context.util.DLRequestHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Adolfo Pérez
 */
@Component(service = DLAdminDisplayContextProvider.class)
public class DLAdminDisplayContextProvider {

	public DLAdminDisplayContext getDLAdminDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		DLRequestHelper dlRequestHelper = new DLRequestHelper(
			httpServletRequest);

		return new DLAdminDisplayContext(
			dlRequestHelper.getLiferayPortletRequest(),
			dlRequestHelper.getLiferayPortletResponse(), _versioningStrategy);
	}

	public DLAdminManagementToolbarDisplayContext
		getDLAdminManagementToolbarDisplayContext(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		DLRequestHelper dlRequestHelper = new DLRequestHelper(
			httpServletRequest);

		return new DLAdminManagementToolbarDisplayContext(
			httpServletRequest, dlRequestHelper.getLiferayPortletRequest(),
			dlRequestHelper.getLiferayPortletResponse(),
			getDLAdminDisplayContext(httpServletRequest, httpServletResponse));
	}

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile VersioningStrategy _versioningStrategy;

}