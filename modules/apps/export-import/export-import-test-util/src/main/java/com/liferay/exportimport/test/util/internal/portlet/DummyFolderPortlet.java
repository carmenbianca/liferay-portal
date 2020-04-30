/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.test.util.internal.portlet;

import com.liferay.exportimport.kernel.lar.PortletDataHandler;
import com.liferay.exportimport.test.util.constants.DummyFolderPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DummyFolderPortletKeys.DUMMY_FOLDER,
		"javax.portlet.resource-bundle=content.Language"
	},
	service = {DummyFolderPortlet.class, Portlet.class}
)
public class DummyFolderPortlet extends MVCPortlet {

	@Reference(
		target = "(javax.portlet.name=" + DummyFolderPortletKeys.DUMMY_FOLDER + ")"
	)
	private PortletDataHandler _dummyFolderPortletDataHandler;

}