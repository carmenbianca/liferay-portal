/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import updateLayoutData from '../actions/updateLayoutData';
import LayoutService from '../services/LayoutService';

export default function moveItem({itemId, parentItemId, position, store}) {
	return dispatch => {
		const {segmentsExperienceId} = store;

		LayoutService.moveItem({
			itemId,
			onNetworkStatus: dispatch,
			parentItemId,
			position,
			segmentsExperienceId,
		}).then(layoutData => {
			dispatch(updateLayoutData({layoutData}));
		});
	};
}
