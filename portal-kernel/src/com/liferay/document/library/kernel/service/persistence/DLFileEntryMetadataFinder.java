/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface DLFileEntryMetadataFinder {

	public java.util.List
		<com.liferay.document.library.kernel.model.DLFileEntryMetadata>
			findByMismatchedCompanyId();

	public java.util.List
		<com.liferay.document.library.kernel.model.DLFileEntryMetadata>
			findByNoStructures();

}