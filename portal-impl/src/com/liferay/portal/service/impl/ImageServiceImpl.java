/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.service.base.ImageServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 * @author Sergio González
 */
public class ImageServiceImpl extends ImageServiceBaseImpl {

	@Override
	public Image getImage(long imageId) throws PortalException {
		return imageLocalService.getImage(imageId);
	}

}