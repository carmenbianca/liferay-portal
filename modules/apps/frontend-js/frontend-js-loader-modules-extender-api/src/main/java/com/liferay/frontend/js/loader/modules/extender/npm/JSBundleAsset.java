/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.loader.modules.extender.npm;

import java.io.IOException;
import java.io.InputStream;

/**
 * Provides contents of a <code>JSBundleObject</code>. These contents can be
 * requested from external apps by using a portal URL or {@link InputStream}.
 *
 * @author Iván Zaera
 */
public interface JSBundleAsset extends JSBundleObject {

	/**
	 * Returns the asset's contents.
	 *
	 * @return an {@link InputStream} that allows reading the bytes inside the
	 *         asset
	 * @throws IOException if an IO exception occurred
	 */
	public InputStream getInputStream() throws IOException;

	/**
	 * Returns the asset's public URL. This URL can be used to retrieve the
	 * asset's contents from external apps by making an HTTP request to the
	 * portal.
	 *
	 * @return the asset's public URL
	 */
	public String getURL();

}