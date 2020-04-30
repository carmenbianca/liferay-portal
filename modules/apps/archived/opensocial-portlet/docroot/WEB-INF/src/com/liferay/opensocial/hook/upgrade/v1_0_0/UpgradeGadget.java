/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.hook.upgrade.v1_0_0;

import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.service.GadgetLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.service.ResourceLocalServiceUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Dennis Ju
 */
public class UpgradeGadget extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		for (Gadget gadget :
				GadgetLocalServiceUtil.getGadgets(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {

			ResourceLocalServiceUtil.addResources(
				gadget.getCompanyId(), 0, 0, Gadget.class.getName(),
				gadget.getGadgetId(), false, false, false);
		}
	}

}