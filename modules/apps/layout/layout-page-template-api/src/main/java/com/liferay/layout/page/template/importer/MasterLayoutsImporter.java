/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.importer;

import java.io.File;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Rubén Pulido
 * @deprecated As of Athanasius (7.3.x), in favour of {@link
 *             #LayoutPageTemplatesImporter}
 */
@Deprecated
@ProviderType
public interface MasterLayoutsImporter {

	public List<MasterLayoutsImporterResultEntry> importFile(
			long userId, long groupId, File file, boolean overwrite)
		throws Exception;

}