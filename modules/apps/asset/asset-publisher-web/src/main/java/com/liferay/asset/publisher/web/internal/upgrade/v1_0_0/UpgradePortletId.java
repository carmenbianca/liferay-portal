/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.upgrade.v1_0_0;

import com.liferay.asset.publisher.constants.AssetPublisherPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Julio Camarero
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"101", AssetPublisherPortletKeys.ASSET_PUBLISHER},
			{"173", AssetPublisherPortletKeys.RECENT_CONTENT},
			{"175", AssetPublisherPortletKeys.RELATED_ASSETS},
			{"193", AssetPublisherPortletKeys.MOST_VIEWED_ASSETS},
			{"194", AssetPublisherPortletKeys.HIGHEST_RATED_ASSETS}
		};
	}

}