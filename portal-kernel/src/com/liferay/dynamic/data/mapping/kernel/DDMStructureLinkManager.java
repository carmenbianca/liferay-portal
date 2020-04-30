/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.kernel;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Rafael Praxedes
 */
@ProviderType
public interface DDMStructureLinkManager {

	public DDMStructureLink addStructureLink(
		long classNameId, long classPK, long structureId);

	public void deleteStructureLink(
			long classNameId, long classPK, long structureId)
		throws PortalException;

	public void deleteStructureLinks(long classNameId, long classPK);

	public List<DDMStructureLink> getClassNameStructureLinks(long classNameId);

	public List<DDMStructureLink> getStructureLinks(
		long classNameId, long classPK);

}