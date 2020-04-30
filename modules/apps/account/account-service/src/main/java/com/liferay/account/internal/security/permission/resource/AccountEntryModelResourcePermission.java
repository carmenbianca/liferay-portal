/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.internal.security.permission.resource;

import com.liferay.account.constants.AccountConstants;
import com.liferay.account.model.AccountEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.account.model.AccountEntry",
	service = ModelResourcePermission.class
)
public class AccountEntryModelResourcePermission
	implements ModelResourcePermission<AccountEntry> {

	@Override
	public void check(
			PermissionChecker permissionChecker, AccountEntry accountEntry,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, accountEntry, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, AccountEntry.class.getName(),
				accountEntry.getAccountEntryId(), actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, long accountEntryId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, accountEntryId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, AccountEntry.class.getName(), accountEntryId,
				actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, AccountEntry accountEntry,
			String actionId)
		throws PortalException {

		return permissionChecker.hasPermission(
			null, AccountEntry.class.getName(),
			accountEntry.getAccountEntryId(), actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long accountEntryId,
			String actionId)
		throws PortalException {

		return permissionChecker.hasPermission(
			null, AccountEntry.class.getName(), accountEntryId, actionId);
	}

	@Override
	public String getModelName() {
		return AccountEntry.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return _portletResourcePermission;
	}

	@Reference(
		target = "(resource.name=" + AccountConstants.RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;

}