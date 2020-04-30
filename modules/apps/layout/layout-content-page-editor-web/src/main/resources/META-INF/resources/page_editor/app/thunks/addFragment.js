/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import addFragmentEntryLinks from '../actions/addFragmentEntryLinks';
import {FRAGMENT_TYPES} from '../config/constants/fragmentTypes';
import FragmentService from '../services/FragmentService';

export default function addFragment({
	fragmentEntryKey,
	groupId,
	parentItemId,
	position,
	selectItem = () => {},
	store,
	type,
}) {
	return dispatch => {
		const {segmentsExperienceId} = store;

		const params = {
			fragmentEntryKey,
			groupId,
			onNetworkStatus: dispatch,
			parentItemId,
			position,
			segmentsExperienceId,
			type,
		};

		const updateState = (fragmentEntryLinks, layoutData, itemId) => {
			dispatch(
				addFragmentEntryLinks({
					fragmentEntryLinks,
					layoutData,
				})
			);

			selectItem(itemId);
		};

		if (type === FRAGMENT_TYPES.composition) {
			FragmentService.addFragmentEntryLinks(params).then(
				({fragmentEntryLinks, layoutData}) => {
					updateState(
						Object.values(fragmentEntryLinks),
						layoutData,
						parentItemId
					);
				}
			);
		}
		else {
			FragmentService.addFragmentEntryLink(params).then(
				({addedItemId, fragmentEntryLink, layoutData}) => {
					updateState([fragmentEntryLink], layoutData, addedItemId);
				}
			);
		}
	};
}
