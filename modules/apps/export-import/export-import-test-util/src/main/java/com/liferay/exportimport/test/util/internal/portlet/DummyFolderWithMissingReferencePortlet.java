/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.test.util.internal.portlet;

import com.liferay.exportimport.test.util.constants.DummyFolderPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Akos Thurzo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DummyFolderPortletKeys.DUMMY_FOLDER_WITH_MISSING_REFERENCE,
		"javax.portlet.resource-bundle=content.Language"
	},
	service = {DummyFolderWithMissingReferencePortlet.class, Portlet.class}
)
public class DummyFolderWithMissingReferencePortlet extends MVCPortlet {
}