/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.internal.info.renderer;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.info.item.renderer.InfoItemRenderer;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jorge Ferrer
 */
@Component(service = InfoItemRenderer.class)
public class FullContentAssetEntryInfoItemRenderer
	extends BaseAssetEntryInfoItemRenderer {

	@Override
	protected String getTemplate() {
		return AssetRenderer.TEMPLATE_FULL_CONTENT;
	}

}