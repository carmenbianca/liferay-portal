/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.internal.instance.lifecycle.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.depot.constants.DepotRolesConstants;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.CompanyTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public class DepotRolesPortalInstanceLifecycleListenerTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testAddCompany() throws Exception {
		Company company = null;

		try {
			company = CompanyTestUtil.addCompany();

			_assertRole(
				company.getCompanyId(),
				DepotRolesConstants.ASSET_LIBRARY_ADMINISTRATOR);
			_assertRole(
				company.getCompanyId(),
				DepotRolesConstants.ASSET_LIBRARY_MEMBER);
			_assertRole(
				company.getCompanyId(),
				DepotRolesConstants.ASSET_LIBRARY_OWNER);
		}
		finally {
			if (company != null) {
				_companyLocalService.deleteCompany(company.getCompanyId());
			}
		}
	}

	private void _assertRole(long companyId, String name)
		throws PortalException {

		try {
			Role role = _roleLocalService.getRole(companyId, name);

			int resourcePermissionsCount =
				_resourcePermissionLocalService.getResourcePermissionsCount(
					companyId, Role.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(role.getRoleId()));

			Assert.assertEquals(1, resourcePermissionsCount);
		}
		catch (NoSuchRoleException noSuchRoleException) {
			throw new AssertionError(noSuchRoleException.getMessage());
		}
		catch (NoSuchResourcePermissionException
					noSuchResourcePermissionException) {

			throw new AssertionError(
				noSuchResourcePermissionException.getMessage());
		}
	}

	@Inject
	private CompanyLocalService _companyLocalService;

	@Inject
	private ResourcePermissionLocalService _resourcePermissionLocalService;

	@Inject
	private RoleLocalService _roleLocalService;

}