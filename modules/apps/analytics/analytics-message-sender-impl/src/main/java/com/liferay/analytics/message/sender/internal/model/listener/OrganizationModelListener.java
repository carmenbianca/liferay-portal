/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.internal.model.listener;

import com.liferay.analytics.message.sender.model.EntityModelListener;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rachael Koestartyo
 */
@Component(
	immediate = true, service = {EntityModelListener.class, ModelListener.class}
)
public class OrganizationModelListener
	extends BaseEntityModelListener<Organization> {

	@Override
	public List<String> getAttributeNames() {
		return getOrganizationAttributeNames();
	}

	@Override
	public long[] getMembershipIds(User user) throws Exception {
		return user.getOrganizationIds();
	}

	@Override
	public String getModelClassName() {
		return Organization.class.getName();
	}

	@Override
	public void onAfterRemove(Organization organization)
		throws ModelListenerException {

		if (!analyticsConfigurationTracker.isActive()) {
			return;
		}

		if (isExcluded(organization)) {
			return;
		}

		updateConfigurationProperties(
			organization.getCompanyId(), "syncedOrganizationIds",
			String.valueOf(organization.getOrganizationId()), null);
	}

	@Override
	protected ActionableDynamicQuery getActionableDynamicQuery() {
		return _organizationLocalService.getActionableDynamicQuery();
	}

	@Override
	protected Organization getModel(long id) throws Exception {
		return _organizationLocalService.getOrganization(id);
	}

	@Override
	protected String getPrimaryKeyName() {
		return "organizationId";
	}

	@Reference
	private OrganizationLocalService _organizationLocalService;

}