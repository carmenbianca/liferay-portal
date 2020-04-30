/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {AVAILABLE_PANELS} from './selectAvailablePanels';

/**
 * @param {{ [panelId: string]: object }} sidebarPanels
 */
export default function selectAvailableSidebarPanels(sidebarPanels) {
	/**
	 * @param {{ permissions: import("../../types/ActionKeys").ActionKeysMap }} state
	 */
	return function({permissions}) {
		if (
			permissions.LOCKED_SEGMENTS_EXPERIMENT ||
			!permissions.UPDATE_LAYOUT_CONTENT
		) {
			const availableSidebarPanels = {};

			AVAILABLE_PANELS.forEach(panelId => {
				availableSidebarPanels[panelId] = sidebarPanels[panelId];
			});

			return availableSidebarPanels;
		}

		return sidebarPanels;
	};
}
