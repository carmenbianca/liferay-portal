/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.event;

import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * @author Roberto Díaz
 * @author Adolfo Pérez
 */
public interface FileVersionPreviewEventListener {

	public void onFailure(FileVersion fileVersion);

	public void onSuccess(FileVersion fileVersion);

}