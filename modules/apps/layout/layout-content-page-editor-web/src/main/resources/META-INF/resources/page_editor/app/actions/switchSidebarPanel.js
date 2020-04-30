/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {SWITCH_SIDEBAR_PANEL} from './types';

export default function switchSidebarPanel({sidebarOpen, sidebarPanelId}) {
	return {
		sidebarOpen,
		sidebarPanelId,
		type: SWITCH_SIDEBAR_PANEL,
	};
}
