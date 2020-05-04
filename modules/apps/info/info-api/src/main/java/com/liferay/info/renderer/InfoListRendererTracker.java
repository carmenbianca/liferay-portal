/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.renderer;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author     Jorge Ferrer
 * @deprecated As of Mueller (7.2.x), moved to {@link
 *             com.liferay.info.list.renderer.InfoListRendererTracker}
 */
@Deprecated
@ProviderType
public interface InfoListRendererTracker {

	public InfoListRenderer getInfoListRenderer(String key);

	public List<InfoListRenderer> getInfoListRenderers();

	public List<InfoListRenderer> getInfoListRenderers(String itemClassName);

}