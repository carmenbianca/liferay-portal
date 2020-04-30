/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.user.action.contributor;

import com.liferay.users.admin.user.action.contributor.UserActionContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pei-Jung Lan
 */
@Component(immediate = true, service = UserActionContributor.class)
public class ExportPersonalDataUserActionContributor
	extends BaseUADUserActionContributor {

	@Override
	protected String getKey() {
		return "export-personal-data";
	}

	@Override
	protected String getMVCRenderCommandName() {
		return "/view_uad_export_processes";
	}

}