/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.bundle;

import java.util.List;

import org.osgi.framework.Bundle;

/**
 * @author Joan Kim
 * @author Ryan Park
 */
public interface BundleManager {

	public Bundle getBundle(String symbolicName, String versionString);

	public List<Bundle> getBundles();

	public List<Bundle> getInstalledBundles();

}