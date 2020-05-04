/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import java.io.Closeable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Raymond Augé
 */
@ProviderType
public interface FriendlyURLMapperTracker extends Closeable {

	@Override
	public void close();

	public FriendlyURLMapper getFriendlyURLMapper();

	public void register(FriendlyURLMapper friendlyURLMapper);

	public void unregister(FriendlyURLMapper friendlyURLMapper);

}