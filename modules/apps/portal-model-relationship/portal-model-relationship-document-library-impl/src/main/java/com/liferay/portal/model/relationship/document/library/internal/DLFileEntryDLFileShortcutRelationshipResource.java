/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.relationship.document.library.internal;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFileShortcutLocalService;
import com.liferay.portal.relationship.Relationship;
import com.liferay.portal.relationship.RelationshipResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Máté Thurzó
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.document.library.kernel.model.DLFileEntry",
	service = RelationshipResource.class
)
public class DLFileEntryDLFileShortcutRelationshipResource
	implements RelationshipResource<DLFileEntry> {

	@Override
	public Relationship<DLFileEntry> relationship(
		Relationship.Builder<DLFileEntry> builder) {

		return builder.modelSupplier(
			fileEntryId -> _dlFileEntryLocalService.fetchDLFileEntry(
				fileEntryId)
		).outboundMultiRelationship(
			dlFileEntry -> _dlFileShortcutLocalService.getFileShortcuts(
				dlFileEntry.getFileEntryId())
		).build();
	}

	@Reference
	private DLFileEntryLocalService _dlFileEntryLocalService;

	@Reference
	private DLFileShortcutLocalService _dlFileShortcutLocalService;

}