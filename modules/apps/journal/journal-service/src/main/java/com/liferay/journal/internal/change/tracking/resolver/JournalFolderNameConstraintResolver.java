/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.change.tracking.resolver;

import com.liferay.change.tracking.resolver.ConstraintResolver;
import com.liferay.change.tracking.resolver.helper.ConstraintResolverHelper;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(service = ConstraintResolver.class)
public class JournalFolderNameConstraintResolver
	implements ConstraintResolver<JournalFolder> {

	@Override
	public String getConflictDescriptionKey() {
		return "duplicate-folder-name";
	}

	@Override
	public Class<JournalFolder> getModelClass() {
		return JournalFolder.class;
	}

	@Override
	public String getResolutionDescriptionKey() {
		return "rename-the-folder-in-the-publication";
	}

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		return ResourceBundleUtil.getBundle(locale, "com.liferay.journal.lang");
	}

	@Override
	public String[] getUniqueIndexColumnNames() {
		return new String[] {"groupId", "parentFolderId", "name"};
	}

	@Override
	public void resolveConflict(
		ConstraintResolverHelper<JournalFolder> constraintResolverHelper) {
	}

	@Reference
	private JournalFolderLocalService _journalFolderLocalService;

}