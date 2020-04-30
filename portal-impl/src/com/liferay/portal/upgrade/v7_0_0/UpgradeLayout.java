/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;

/**
 * @author Jonathan McCann
 */
public class UpgradeLayout extends UpgradeProcess {

	protected void deleteLinkedOrphanedLayouts() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			StringBundler sb = new StringBundler(3);

			sb.append("delete from Layout where layoutPrototypeUuid != '' ");
			sb.append("and layoutPrototypeUuid not in (select uuid_ from ");
			sb.append("LayoutPrototype) and layoutPrototypeLinkEnabled = TRUE");

			runSQL(sb.toString());
		}
	}

	protected void deleteOrphanedFriendlyURL() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			runSQL(
				"delete from LayoutFriendlyURL where plid not in (select " +
					"plid from Layout)");
		}
	}

	@Override
	protected void doUpgrade() throws Exception {
		deleteLinkedOrphanedLayouts();
		deleteOrphanedFriendlyURL();
		updateLayoutPrototypeLinkEnabled();
		updateUnlinkedOrphanedLayouts();
	}

	protected void updateLayoutPrototypeLinkEnabled() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			runSQL(
				"update Layout set layoutPrototypeLinkEnabled = [$FALSE$] " +
					"where type_ = 'link_to_layout' and " +
						"layoutPrototypeLinkEnabled = [$TRUE$]");
		}
	}

	protected void updateUnlinkedOrphanedLayouts() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			StringBundler sb = new StringBundler(4);

			sb.append("update Layout set layoutPrototypeUuid = null where ");
			sb.append("layoutPrototypeUuid != '' and layoutPrototypeUuid not ");
			sb.append("in (select uuid_ from LayoutPrototype) and ");
			sb.append("layoutPrototypeLinkEnabled = FALSE");

			runSQL(sb.toString());
		}
	}

}