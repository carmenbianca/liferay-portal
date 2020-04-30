/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import LayoutService from '../services/LayoutService';

export default function resizeColumns({layoutData, store}) {
	return dispatch => {
		const {segmentsExperienceId} = store;

		return LayoutService.updateLayoutData({
			layoutData,
			onNetworkStatus: dispatch,
			segmentsExperienceId,
		});
	};
}
