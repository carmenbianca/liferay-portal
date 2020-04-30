/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for LayoutSetBranch. This utility wraps
 * <code>com.liferay.portal.service.impl.LayoutSetBranchServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetBranchService
 * @generated
 */
public class LayoutSetBranchServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.LayoutSetBranchServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.LayoutSetBranch
			addLayoutSetBranch(
				long groupId, boolean privateLayout, String name,
				String description, boolean master, long copyLayoutSetBranchId,
				ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addLayoutSetBranch(
			groupId, privateLayout, name, description, master,
			copyLayoutSetBranchId, serviceContext);
	}

	public static void deleteLayoutSetBranch(long layoutSetBranchId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteLayoutSetBranch(layoutSetBranchId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.LayoutSetBranch> getLayoutSetBranches(
			long groupId, boolean privateLayout) {

		return getService().getLayoutSetBranches(groupId, privateLayout);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.LayoutSetBranch
			mergeLayoutSetBranch(
				long layoutSetBranchId, long mergeLayoutSetBranchId,
				ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().mergeLayoutSetBranch(
			layoutSetBranchId, mergeLayoutSetBranchId, serviceContext);
	}

	public static com.liferay.portal.kernel.model.LayoutSetBranch
			updateLayoutSetBranch(
				long groupId, long layoutSetBranchId, String name,
				String description, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateLayoutSetBranch(
			groupId, layoutSetBranchId, name, description, serviceContext);
	}

	public static LayoutSetBranchService getService() {
		if (_service == null) {
			_service = (LayoutSetBranchService)PortalBeanLocatorUtil.locate(
				LayoutSetBranchService.class.getName());
		}

		return _service;
	}

	private static LayoutSetBranchService _service;

}