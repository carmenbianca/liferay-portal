/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {useHoverItem, useSelectItem} from '../../../app/components/Controls';
import {LAYOUT_DATA_ITEM_TYPES} from '../../../app/config/constants/layoutDataItemTypes';
import {useSelector} from '../../../app/store/index';
import SidebarPanelContent from '../../../common/components/SidebarPanelContent';
import SidebarPanelHeader from '../../../common/components/SidebarPanelHeader';
import NoCommentsMessage from './NoCommentsMessage';
import ResolvedCommentsToggle from './ResolvedCommentsToggle';

export default function FragmentEntryLinksWithComments() {
	const itemsWithComments = useSelector(state =>
		Object.values(state.layoutData.items)
			.filter(item => item.type === LAYOUT_DATA_ITEM_TYPES.fragment)
			.map(item => [
				item,
				state.fragmentEntryLinks[item.config.fragmentEntryLinkId],
			])
			.map(([item, fragmentEntryLink]) => [
				item,
				{
					...fragmentEntryLink,
					comments: (fragmentEntryLink.comments || []).filter(
						({resolved}) =>
							(state.showResolvedComments && resolved) ||
							!resolved
					),
				},
			])
			.filter(
				([, fragmentEntryLink]) => fragmentEntryLink.comments.length
			)
	);

	return (
		<>
			<SidebarPanelHeader>
				{Liferay.Language.get('comments')}
			</SidebarPanelHeader>

			<SidebarPanelContent padded={false}>
				<ResolvedCommentsToggle />

				{itemsWithComments.length ? (
					<nav className="list-group">
						{itemsWithComments.map(([item, fragmentEntryLink]) => (
							<FragmentEntryLinkWithComments
								fragmentEntryLink={fragmentEntryLink}
								item={item}
								key={fragmentEntryLink.fragmentEntryLinkId}
							/>
						))}
					</nav>
				) : (
					<NoCommentsMessage />
				)}
			</SidebarPanelContent>
		</>
	);
}

function FragmentEntryLinkWithComments({fragmentEntryLink, item}) {
	const selectItem = useSelectItem();
	const hoverItem = useHoverItem();

	return (
		<a
			className="border-0 list-group-item list-group-item-action"
			href={`#${fragmentEntryLink.fragmentEntryLinkId}`}
			onClick={() => selectItem(item.itemId)}
			onFocus={() => hoverItem(item.itemId)}
			onMouseOut={() => hoverItem(null)}
			onMouseOver={() => hoverItem(item.itemId)}
		>
			<strong className="d-block text-dark">
				{fragmentEntryLink.name}
			</strong>

			<span className="text-secondary">
				{Liferay.Util.sub(
					fragmentEntryLink.comments.length === 1
						? Liferay.Language.get('x-comment')
						: Liferay.Language.get('x-comments'),
					fragmentEntryLink.comments.length
				)}
			</span>
		</a>
	);
}
