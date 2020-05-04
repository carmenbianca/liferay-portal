/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

/**
 * Provides a wrapper for {@link ImageService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImageService
 * @generated
 */
public class ImageServiceWrapper
	implements ImageService, ServiceWrapper<ImageService> {

	public ImageServiceWrapper(ImageService imageService) {
		_imageService = imageService;
	}

	@Override
	public com.liferay.portal.kernel.model.Image getImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _imageService.getImage(imageId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _imageService.getOSGiServiceIdentifier();
	}

	@Override
	public ImageService getWrappedService() {
		return _imageService;
	}

	@Override
	public void setWrappedService(ImageService imageService) {
		_imageService = imageService;
	}

	private ImageService _imageService;

}