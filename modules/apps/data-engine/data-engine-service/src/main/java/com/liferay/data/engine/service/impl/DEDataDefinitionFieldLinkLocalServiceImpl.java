/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.service.impl;

import com.liferay.data.engine.model.DEDataDefinitionFieldLink;
import com.liferay.data.engine.service.base.DEDataDefinitionFieldLinkLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.data.engine.model.DEDataDefinitionFieldLink",
	service = AopService.class
)
public class DEDataDefinitionFieldLinkLocalServiceImpl
	extends DEDataDefinitionFieldLinkLocalServiceBaseImpl {

	@Override
	public DEDataDefinitionFieldLink addDEDataDefinitionFieldLink(
			long groupId, long classNameId, long classPK, long ddmStructureId,
			String fieldName)
		throws PortalException {

		return addDEDataDefinitionFieldLink(
			groupId, classNameId, classPK, ddmStructureId, fieldName,
			new ServiceContext());
	}

	@Override
	public DEDataDefinitionFieldLink addDEDataDefinitionFieldLink(
			long groupId, long classNameId, long classPK, long ddmStructureId,
			String fieldName, ServiceContext serviceContext)
		throws PortalException {

		DEDataDefinitionFieldLink deDataDefinitionFieldLink =
			deDataDefinitionFieldLinkPersistence.create(
				counterLocalService.increment());

		deDataDefinitionFieldLink.setUuid(serviceContext.getUuid());
		deDataDefinitionFieldLink.setGroupId(groupId);

		Group group = groupLocalService.getGroup(groupId);

		deDataDefinitionFieldLink.setCompanyId(group.getCompanyId());

		Date now = new Date();

		deDataDefinitionFieldLink.setCreateDate(
			serviceContext.getCreateDate(now));
		deDataDefinitionFieldLink.setModifiedDate(
			serviceContext.getModifiedDate(now));

		deDataDefinitionFieldLink.setClassNameId(classNameId);
		deDataDefinitionFieldLink.setClassPK(classPK);
		deDataDefinitionFieldLink.setDdmStructureId(ddmStructureId);
		deDataDefinitionFieldLink.setFieldName(fieldName);

		return deDataDefinitionFieldLinkPersistence.update(
			deDataDefinitionFieldLink);
	}

	@Override
	public void deleteDEDataDefinitionFieldLinks(long ddmStructureId) {
		deDataDefinitionFieldLinkPersistence.removeByDDMStructureId(
			ddmStructureId);
	}

	@Override
	public void deleteDEDataDefinitionFieldLinks(
		long classNameId, long classPK) {

		deDataDefinitionFieldLinkPersistence.removeByC_C(classNameId, classPK);
	}

	@Override
	public void deleteDEDataDefinitionFieldLinks(
		long classNameId, long ddmStructureId, String fieldName) {

		deDataDefinitionFieldLinkPersistence.removeByC_DDMSI_F(
			classNameId, ddmStructureId, fieldName);
	}

	@Override
	public List<DEDataDefinitionFieldLink> getDEDataDefinitionFieldLinks(
		long ddmStructureId) {

		return deDataDefinitionFieldLinkPersistence.findByDDMStructureId(
			ddmStructureId);
	}

	@Override
	public List<DEDataDefinitionFieldLink> getDEDataDefinitionFieldLinks(
		long classNameId, long ddmStructureId, String fieldName) {

		return deDataDefinitionFieldLinkPersistence.findByC_DDMSI_F(
			classNameId, ddmStructureId, fieldName);
	}

}