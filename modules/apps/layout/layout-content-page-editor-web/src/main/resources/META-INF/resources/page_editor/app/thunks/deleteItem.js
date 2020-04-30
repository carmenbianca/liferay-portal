/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import deleteWidgets from '../actions/deleteWidgets';
import updateLayoutData from '../actions/updateLayoutData';
import updatePageContents from '../actions/updatePageContents';
import InfoItemService from '../services/InfoItemService';
import LayoutService from '../services/LayoutService';

export default function deleteItem({itemId, store}) {
	return dispatch => {
		const {segmentsExperienceId} = store;

		return LayoutService.deleteItem({
			itemId,
			onNetworkStatus: dispatch,
			segmentsExperienceId,
		})
			.then(({deletedFragmentEntryLinkIds = [], layoutData}) => {
				const deletedWidgets = deletedFragmentEntryLinkIds
					.map(
						fragmentEntryLinkId =>
							store.fragmentEntryLinks[fragmentEntryLinkId]
					)
					.filter(
						fragmentEntryLink =>
							fragmentEntryLink.editableValues.portletId
					);

				if (deletedWidgets.length) {
					dispatch(deleteWidgets(deletedWidgets));
				}

				dispatch(
					updateLayoutData({deletedFragmentEntryLinkIds, layoutData})
				);
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
	};
}
