/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal;

import com.liferay.dynamic.data.mapping.kernel.DDMStructureLink;
import com.liferay.dynamic.data.mapping.kernel.DDMStructureLinkManager;
import com.liferay.dynamic.data.mapping.service.DDMStructureLinkLocalService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(immediate = true, service = DDMStructureLinkManager.class)
public class DDMStructureLinkManagerImpl implements DDMStructureLinkManager {

	@Override
	public DDMStructureLink addStructureLink(
		long classNameId, long classPK, long structureId) {

		com.liferay.dynamic.data.mapping.model.DDMStructureLink
			ddmStructureLink = _ddmStructureLinkLocalService.addStructureLink(
				classNameId, classPK, structureId);

		return new DDMStructureLinkImpl(ddmStructureLink);
	}

	@Override
	public void deleteStructureLink(
			long classNameId, long classPK, long structureId)
		throws PortalException {

		_ddmStructureLinkLocalService.deleteStructureLink(
			classNameId, classPK, structureId);
	}

	@Override
	public void deleteStructureLinks(long classNameId, long classPK) {
		_ddmStructureLinkLocalService.deleteStructureLinks(
			classNameId, classPK);
	}

	@Override
	public List<DDMStructureLink> getClassNameStructureLinks(long classNameId) {
		List<DDMStructureLink> ddmStructureLinks = new ArrayList<>();

		for (com.liferay.dynamic.data.mapping.model.DDMStructureLink
				structureLink :
					_ddmStructureLinkLocalService.getClassNameStructureLinks(
						classNameId)) {

			ddmStructureLinks.add(new DDMStructureLinkImpl(structureLink));
		}

		return ddmStructureLinks;
	}

	@Override
	public List<DDMStructureLink> getStructureLinks(
		long classNameId, long classPK) {

		List<DDMStructureLink> ddmStructureLinks = new ArrayList<>();

		for (com.liferay.dynamic.data.mapping.model.DDMStructureLink
				ddmStructureLink :
					_ddmStructureLinkLocalService.getStructureLinks(
						classNameId, classPK)) {

			ddmStructureLinks.add(new DDMStructureLinkImpl(ddmStructureLink));
		}

		return ddmStructureLinks;
	}

	@Reference(unbind = "-")
	protected void setDDMStructureLinkLocalService(
		DDMStructureLinkLocalService ddmStructureLinkLocalService) {

		_ddmStructureLinkLocalService = ddmStructureLinkLocalService;
	}

	private DDMStructureLinkLocalService _ddmStructureLinkLocalService;

}