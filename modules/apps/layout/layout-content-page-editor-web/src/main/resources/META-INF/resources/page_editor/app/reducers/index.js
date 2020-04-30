/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import baseReducer from './baseReducer';
import collectionsReducer from './collectionsReducer';
import fragmentEntryLinksReducer from './fragmentEntryLinksReducer';
import fragmentsReducer from './fragmentsReducer';
import languageIdReducer from './languageIdReducer';
import layoutDataReducer from './layoutDataReducer';
import mappedInfoItemsReducer from './mappedInfoItemsReducer';
import networkReducer from './networkReducer';
import pageContentsReducer from './pageContentsReducer';
import permissionsReducer from './permissionsReducer';
import selectedViewportSizeReducer from './selectedViewportSizeReducer';
import showResolvedCommentsReducer from './showResolvedCommentsReducer';
import sidebarReducer from './sidebarReducer';
import widgetsReducer from './widgetsReducer';

/**
 * Runs the base reducer plus any dynamically loaded reducers that have
 * been registered from plugins.
 */
export function reducer(state, action) {
	return [combinedReducer, ...Object.values(state.reducers || {})].reduce(
		(nextState, nextReducer) => {
			return nextReducer(nextState, action);
		},
		state
	);
}

const combinedReducer = (state, action) =>
	Object.entries({
		collections: collectionsReducer,
		fragmentEntryLinks: fragmentEntryLinksReducer,
		fragments: fragmentsReducer,
		languageId: languageIdReducer,
		layoutData: layoutDataReducer,
		mappedInfoItems: mappedInfoItemsReducer,
		network: networkReducer,
		pageContents: pageContentsReducer,
		permissions: permissionsReducer,
		reducers: baseReducer,
		selectedViewportSize: selectedViewportSizeReducer,
		showResolvedComments: showResolvedCommentsReducer,
		sidebar: sidebarReducer,
		widgets: widgetsReducer,
	}).reduce(
		(nextState, [namespace, reducer]) => ({
			...nextState,
			[namespace]: reducer(nextState[namespace], action),
		}),
		state
	);
