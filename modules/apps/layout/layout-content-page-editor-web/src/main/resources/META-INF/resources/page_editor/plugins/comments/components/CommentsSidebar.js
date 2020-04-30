/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {useActiveItemId} from '../../../app/components/Controls';
import {LAYOUT_DATA_ITEM_TYPES} from '../../../app/config/constants/layoutDataItemTypes';
import {useSelector} from '../../../app/store/index';
import FragmentComments from './FragmentComments';
import FragmentEntryLinksWithComments from './FragmentEntryLinksWithComments';

function getActiveFragmentEntryLink(itemId, fragmentEntryLinks, layoutData) {
	const item = layoutData.items[itemId];

	if (item) {
		if (item.type === LAYOUT_DATA_ITEM_TYPES.fragment) {
			return fragmentEntryLinks[item.config.fragmentEntryLinkId];
		}
		else if (item.parentId) {
			return getActiveFragmentEntryLink(
				item.parentId,
				fragmentEntryLinks,
				layoutData
			);
		}
	}

	return null;
}

export default function CommentsSidebar() {
	const fragmentEntryLinks = useSelector(state => state.fragmentEntryLinks);
	const layoutData = useSelector(state => state.layoutData);

	const activeItemId = useActiveItemId();

	const activeFragmentEntryLink = getActiveFragmentEntryLink(
		activeItemId,
		fragmentEntryLinks,
		layoutData
	);

	return (
		<div
			onMouseDown={event => event.nativeEvent.stopImmediatePropagation()}
		>
			{activeFragmentEntryLink ? (
				<FragmentComments fragmentEntryLink={activeFragmentEntryLink} />
			) : (
				<FragmentEntryLinksWithComments />
			)}
		</div>
	);
}
