/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export const AVAILABLE_PANELS = ['comments', 'contents', 'page-structure'];

/**
 * @param {Array<Array<string>>} panels
 */
export default function selectAvailablePanels(panels) {
	/**
	 * @param {{ permissions: import("../../types/ActionKeys").ActionKeysMap }} state
	 */
	return function({permissions}) {
		if (
			permissions.LOCKED_SEGMENTS_EXPERIMENT ||
			!permissions.UPDATE_LAYOUT_CONTENT
		) {
			return panels
				.map(group =>
					group.filter(panelId => AVAILABLE_PANELS.includes(panelId))
				)
				.filter(group => group.length);
		}

		return panels;
	};
}
