/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.web.internal.upgrade;

import com.liferay.mobile.device.rules.web.internal.rule.group.action.LayoutTemplateModificationActionHandler;
import com.liferay.mobile.device.rules.web.internal.rule.group.action.SimpleRedirectActionHandler;
import com.liferay.mobile.device.rules.web.internal.rule.group.action.SiteRedirectActionHandler;
import com.liferay.mobile.device.rules.web.internal.rule.group.action.ThemeModificationActionHandler;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Tom Wang
 */
public class MDRActionUpgrade extends UpgradeProcess {

	public MDRActionUpgrade(String oldPackageName, String newPackageName) {
		_oldPackageName = oldPackageName;
		_newPackageName = newPackageName;
	}

	@Override
	public void doUpgrade() throws Exception {
		_updateMDRAction(
			LayoutTemplateModificationActionHandler.class.getSimpleName());
		_updateMDRAction(SimpleRedirectActionHandler.class.getSimpleName());
		_updateMDRAction(SiteRedirectActionHandler.class.getSimpleName());
		_updateMDRAction(ThemeModificationActionHandler.class.getSimpleName());
	}

	private void _updateMDRAction(String name) throws Exception {
		runSQL(
			StringBundler.concat(
				"update MDRAction set type_ = '", _newPackageName, ".", name,
				"' where type_ = '", _oldPackageName, ".", name, "'"));
	}

	private final String _newPackageName;
	private final String _oldPackageName;

}