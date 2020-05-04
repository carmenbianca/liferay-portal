/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.tools.service.builder.test.model.LVEntryLocalizationVersion;
import com.liferay.portal.tools.service.builder.test.service.base.LVEntryLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class LVEntryLocalServiceImpl extends LVEntryLocalServiceBaseImpl {

	@Override
	public LVEntryLocalizationVersion fetchLVEntryLocalizationVersion(
		long lvEntryId, String languageId, int version) {

		return lvEntryLocalizationVersionPersistence.
			fetchByLvEntryId_LanguageId_Version(lvEntryId, languageId, version);
	}

	@Override
	public List<LVEntryLocalizationVersion> getLVEntryLocalizationVersions(
		long lvEntryId) {

		return lvEntryLocalizationVersionPersistence.findByLvEntryId(lvEntryId);
	}

	@Override
	public List<LVEntryLocalizationVersion> getLVEntryLocalizationVersions(
			long lvEntryId, String languageId)
		throws PortalException {

		return lvEntryLocalizationVersionPersistence.findByLvEntryId_LanguageId(
			lvEntryId, languageId);
	}

}