/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.html;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;

/**
 * @author Alejandro Tardín
 */
public interface AMImageHTMLTagFactory {

	public String create(String originalImgTag, FileEntry fileEntry)
		throws PortalException;

}