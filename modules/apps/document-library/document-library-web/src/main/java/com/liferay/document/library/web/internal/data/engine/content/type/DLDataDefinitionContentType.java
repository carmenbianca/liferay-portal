/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.data.engine.content.type;

import com.liferay.data.engine.content.type.DataDefinitionContentType;
import com.liferay.document.library.kernel.model.DLFileEntryMetadata;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.documentlibrary.constants.DLConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alicia García
 */
@Component(
	immediate = true, property = "content.type=document-library",
	service = DataDefinitionContentType.class
)
public class DLDataDefinitionContentType implements DataDefinitionContentType {

	@Override
	public long getClassNameId() {
		return _portal.getClassNameId(DLFileEntryMetadata.class);
	}

	@Override
	public String getContentType() {
		return "document-library";
	}

	@Override
	public String getPortletResourceName() {
		return DLConstants.RESOURCE_NAME;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long companyId, long groupId,
			String resourceName, long primKey, long userId, String actionId)
		throws PortalException {

		if (StringUtil.contains(DDLRecordSet.class.getName(), resourceName)) {
			DDLRecordSet ddlRecordSet = _ddlRecordSetLocalService.getRecordSet(
				primKey);

			DDMStructure ddmStructure = ddlRecordSet.getDDMStructure();

			resourceName = ResourceActionsUtil.getCompositeModelName(
				_portal.getClassName(ddmStructure.getClassNameId()),
				DDMStructure.class.getName());

			primKey = ddlRecordSet.getDDMStructureId();
		}

		if (permissionChecker.hasOwnerPermission(
				companyId, resourceName, primKey, userId, actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			groupId, resourceName, primKey, actionId);
	}

	@Override
	public boolean hasPortletPermission(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (actionId.equals("ADD_DATA_DEFINITION") ||
			actionId.equals("ADD_DATA_RECORD_COLLECTION")) {

			return _portletResourcePermission.contains(
				permissionChecker, groupId, "ADD_STRUCTURE");
		}

		return _portletResourcePermission.contains(
			permissionChecker, groupId, actionId);
	}

	@Reference
	private DDLRecordSetLocalService _ddlRecordSetLocalService;

	@Reference
	private Portal _portal;

	@Reference(target = "(resource.name=" + DLConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

}