/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.search.result;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface SearchResultImage {

	public String getClassName();

	public long getClassPK();

	public void setIcon(String iconId);

	public void setThumbnail(String thumbnailURLString);

}