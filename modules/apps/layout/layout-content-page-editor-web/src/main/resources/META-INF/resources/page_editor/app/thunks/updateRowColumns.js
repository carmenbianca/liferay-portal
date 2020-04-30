/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import updateLayoutData from '../actions/updateLayoutData';
import LayoutService from '../services/LayoutService';

export default function updateRowColumns({
	itemId,
	numberOfColumns,
	segmentsExperienceId,
}) {
	return dispatch =>
		LayoutService.updateRowColumns({
			itemId,
			numberOfColumns,
			onNetworkStatus: dispatch,
			segmentsExperienceId,
		}).then(({layoutData}) => {
			dispatch(updateLayoutData({layoutData}));
		});
}
