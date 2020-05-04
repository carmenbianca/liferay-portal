/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.internal.model.listener;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author István András Dézsi
 */
@Component(immediate = true, service = ModelListener.class)
public class RoleModelListener extends BaseModelListener<Role> {

	@Override
	public void onBeforeRemove(Role role) throws ModelListenerException {
		try {
			_deleteKaleoTaskAssignmentByRole(role.getRoleId());
		}
		catch (Exception exception) {
			throw new ModelListenerException(exception);
		}
	}

	@Reference(unbind = "-")
	protected void setKaleoTaskAssignmentLocalService(
		KaleoTaskAssignmentLocalService kaleoTaskAssignmentLocalService) {

		_kaleoTaskAssignmentLocalService = kaleoTaskAssignmentLocalService;
	}

	private void _deleteKaleoTaskAssignmentByRole(final long roleId)
		throws PortalException {

		ActionableDynamicQuery actionableDynamicQuery =
			_kaleoTaskAssignmentLocalService.getActionableDynamicQuery();

		actionableDynamicQuery.setAddCriteriaMethod(
			dynamicQuery -> {
				Property assigneeClassNameProperty =
					PropertyFactoryUtil.forName("assigneeClassName");

				dynamicQuery.add(
					assigneeClassNameProperty.like(Role.class.getName()));

				Property assigneeClassPKProperty = PropertyFactoryUtil.forName(
					"assigneeClassPK");

				dynamicQuery.add(assigneeClassPKProperty.eq(roleId));
			});
		actionableDynamicQuery.setPerformActionMethod(
			(KaleoTaskAssignment kaleoTaskAssignment) ->
				_kaleoTaskAssignmentLocalService.deleteKaleoTaskAssignment(
					kaleoTaskAssignment));

		actionableDynamicQuery.performActions();
	}

	private KaleoTaskAssignmentLocalService _kaleoTaskAssignmentLocalService;

}