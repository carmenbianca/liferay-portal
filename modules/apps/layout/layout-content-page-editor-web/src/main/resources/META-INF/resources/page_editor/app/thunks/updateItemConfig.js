/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import updateLayoutData from '../actions/updateLayoutData';
import updatePageContents from '../actions/updatePageContents';
import InfoItemService from '../services/InfoItemService';
import LayoutService from '../services/LayoutService';

export default function updateItemConfig({
	itemConfig,
	itemId,
	segmentsExperienceId,
}) {
	return dispatch =>
		LayoutService.updateItemConfig({
			itemConfig,
			itemId,
			onNetworkStatus: dispatch,
			segmentsExperienceId,
		})
			.then(layoutData => {
				dispatch(updateLayoutData({layoutData}));
			})
			.then(() => {
				InfoItemService.getPageContents({
					onNetworkStatus: dispatch,
				}).then(pageContents => {
					dispatch(
						updatePageContents({
							pageContents,
						})
					);
				});
			});
}
