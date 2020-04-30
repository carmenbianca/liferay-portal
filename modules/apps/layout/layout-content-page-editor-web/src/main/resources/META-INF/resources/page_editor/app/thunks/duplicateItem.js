/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {updateLayoutData} from '../actions/index';
import FragmentService from '../services/FragmentService';

export default function duplicateItem({itemId, store, selectItem = () => {}}) {
	const {segmentsExperienceId} = store;

	return dispatch => {
		FragmentService.duplicateItem({
			itemId,
			onNetworkStatus: dispatch,
			segmentsExperienceId,
		}).then(
			({duplicatedFragmentEntryLinks, duplicatedItemId, layoutData}) => {
				dispatch(
					updateLayoutData({
						addedFragmentEntryLinks: duplicatedFragmentEntryLinks,
						layoutData,
					})
				);

				if (duplicatedItemId) {
					selectItem(duplicatedItemId);
				}
			}
		);
	};
}
