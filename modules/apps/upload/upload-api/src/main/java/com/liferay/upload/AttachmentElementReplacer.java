/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.upload;

import com.liferay.portal.kernel.repository.model.FileEntry;

/**
 * @author Alejandro Tardín
 * @author Jürgen Kappler
 */
public interface AttachmentElementReplacer {

	public String replace(String originalElement, FileEntry fileEntry);

}