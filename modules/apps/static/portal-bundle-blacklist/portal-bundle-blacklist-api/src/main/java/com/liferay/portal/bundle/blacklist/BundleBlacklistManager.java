/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.bundle.blacklist;

import java.io.IOException;

import java.util.Collection;

/**
 * @author Preston Crary
 */
public interface BundleBlacklistManager {

	public void addToBlacklistAndUninstall(String... bundleSymbolicNames)
		throws IOException;

	public Collection<String> getBlacklistBundleSymbolicNames();

	public void removeFromBlacklistAndInstall(String... bundleSymbolicNames)
		throws IOException;

}