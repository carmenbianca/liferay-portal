/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {SWITCH_SIDEBAR_PANEL} from '../actions/types';

const DEFAULT_PANEL_ID = 'fragments';

export const INITIAL_STATE = {
	open: false,
	panelId: DEFAULT_PANEL_ID,
};

export default function sidebarReducer(sidebarStatus = INITIAL_STATE, action) {
	if (action.type === SWITCH_SIDEBAR_PANEL) {
		return {
			open: action.sidebarOpen,
			panelId:
				action.sidebarPanelId === undefined
					? sidebarStatus.panelId
					: action.sidebarPanelId,
		};
	}

	return sidebarStatus;
}
