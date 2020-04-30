/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.media.query;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;

import java.util.List;

/**
 * @author Alejandro Tardín
 */
public interface MediaQueryProvider {

	public List<MediaQuery> getMediaQueries(FileEntry fileEntry)
		throws PortalException;

}