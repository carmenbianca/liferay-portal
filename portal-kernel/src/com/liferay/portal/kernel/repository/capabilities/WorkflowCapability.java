/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.capabilities;

import com.liferay.portal.kernel.repository.model.FileEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Adolfo Pérez
 */
@ProviderType
public interface WorkflowCapability extends Capability {

	public int getStatus(FileEntry fileEntry);

	public enum OperationMode {

		FULL, MINIMAL

	}

}