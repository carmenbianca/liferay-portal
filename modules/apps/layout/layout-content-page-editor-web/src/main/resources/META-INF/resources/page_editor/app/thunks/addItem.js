/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import updateLayoutData from '../actions/updateLayoutData';
import LayoutService from '../services/LayoutService';

export default function addItem({
	itemType,
	parentItemId,
	position,
	selectItem = () => {},
	store,
}) {
	return dispatch => {
		const {segmentsExperienceId} = store;

		LayoutService.addItem({
			itemType,
			onNetworkStatus: dispatch,
			parentItemId,
			position,
			segmentsExperienceId,
		}).then(({addedItemId, layoutData}) => {
			dispatch(updateLayoutData({layoutData}));

			if (addedItemId) {
				selectItem(addedItemId);
			}
		});
	};
}
