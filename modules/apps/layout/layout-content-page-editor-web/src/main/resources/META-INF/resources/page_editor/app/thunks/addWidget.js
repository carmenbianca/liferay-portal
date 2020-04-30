/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import addFragmentEntryLinks from '../actions/addFragmentEntryLinks';
import WidgetService from '../services/WidgetService';

export default function addWidget({parentItemId, portletId, position, store}) {
	return dispatch => {
		const {segmentsExperienceId} = store;

		WidgetService.addPortlet({
			onNetworkStatus: dispatch,
			parentItemId,
			portletId,
			position,
			segmentsExperienceId,
		}).then(({fragmentEntryLink, layoutData}) => {
			dispatch(
				addFragmentEntryLinks({
					fragmentEntryLinks: [fragmentEntryLink],
					layoutData,
				})
			);
		});
	};
}
