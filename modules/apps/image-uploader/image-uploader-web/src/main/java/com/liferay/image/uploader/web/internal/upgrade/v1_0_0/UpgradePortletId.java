/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.image.uploader.web.internal.upgrade.v1_0_0;

import com.liferay.image.uploader.web.internal.constants.ImageUploaderPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Peter Fellwock
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"195", ImageUploaderPortletKeys.IMAGE_UPLOADER}
		};
	}

}