/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.image.editor.web.internal.portlet;

import com.liferay.frontend.image.editor.web.internal.constants.ImageEditorPortletKeys;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.EditPortletProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.kernel.model.Image",
	service = EditPortletProvider.class
)
public class ImageEditorPortletProvider
	extends BasePortletProvider implements EditPortletProvider {

	@Override
	public String getPortletName() {
		return ImageEditorPortletKeys.IMAGE_EDITOR;
	}

}