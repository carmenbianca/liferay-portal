/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.versioning;

import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;

import java.util.Optional;

/**
 * @author Adolfo Pérez
 */
public interface VersioningPolicy {

	public Optional<DLVersionNumberIncrease> computeDLVersionNumberIncrease(
		DLFileVersion previousDLFileVersion, DLFileVersion nextDLFileVersion);

}