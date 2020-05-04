/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.validator.internal;

import com.liferay.asset.kernel.exception.AssetTagException;
import com.liferay.asset.kernel.validator.AssetEntryValidator;
import com.liferay.message.boards.model.MBDiscussion;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ArrayUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	immediate = true, property = "model.class.name=*",
	service = AssetEntryValidator.class
)
public class AtLeastOneTagAssetEntryValidator implements AssetEntryValidator {

	@Override
	public void validate(
			long groupId, String className, long classTypePK,
			long[] categoryIds, String[] tagNames)
		throws PortalException {

		if (!className.equals(MBDiscussion.class.getName()) &&
			!className.equals(Layout.class.getName()) &&
			!className.equals(User.class.getName()) &&
			ArrayUtil.isEmpty(tagNames)) {

			throw new AssetTagException(AssetTagException.AT_LEAST_ONE_TAG);
		}
	}

}