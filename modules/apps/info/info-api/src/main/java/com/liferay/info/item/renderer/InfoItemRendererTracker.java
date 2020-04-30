/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.item.renderer;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jorge Ferrer
 */
@ProviderType
public interface InfoItemRendererTracker {

	public InfoItemRenderer getInfoItemRenderer(String key);

	public List<InfoItemRenderer> getInfoItemRenderers();

	public List<InfoItemRenderer> getInfoItemRenderers(String itemClassName);

}